// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//Librerias
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
//Comunicacion entre archivos
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.commands.ExampleCommand;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Intake;
import frc.robot.commands.Climb;
import frc.robot.commands.Drive;
import frc.robot.commands.Shoot;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //Subsistemas del robot
  private final Chassis chassis = new Chassis();
  private final Climber climber = new Climber();
  private final Intake intake = new Intake();
  private final Shooter shooter = new Shooter();
  public static XboxController ControlX = new XboxController(OIConstants.kControllerPort);
  
  //Comandos del robot
  private final Climb climb = new Climb(climber);
  private final Drive drive = new Drive(chassis);
  //private final Climb climb = new Climb(climber);


  SendableChooser<String> autonomous = new SendableChooser<String>();


  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    chassis.setDefaultCommand(drive);
    climber.setDefaultCommand(climb);
    
    autonomous.addOption("Izquierda", "izquierda");
    autonomous.addOption("Centro", "centro");
    autonomous.addOption("Derecha", "derecha");
  }
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    //Mapeo de los botones
    new JoystickButton(ControlX, 1).whileHeld(new Shoot(shooter));
    //new JoystickButton(ControlX, 2).whenPressed(new InstantCommand(intake::toExtendIntake, intake));
    //new JoystickButton(ControlX, 3).whenPressed(new InstantCommand(intake::saveIntake, intake));
    
    //POV
    //new POVButton(ControlX, 270).whileHeld(new EjectBalls(intake));
    //new POVButton(ControlX, 0).whileHeld(new EjectBalls(intake));
  






  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
  if(autonomous.getSelected() == "izquierda"){
    //return new SequentialCommandGroup(new Shoot(shooter, intake, chassis).withTimeout(3.6), new PrintCommand("3"), new PrintCommand("4"));
    }
    else if(autonomous.getSelected() == "centro"){
      return new SequentialCommandGroup(new PrintCommand("1"),
      new PrintCommand("2"), new PrintCommand("3"), new PrintCommand("4"));
    }
    
    else if(autonomous.getSelected() == "derecha"){
      return new SequentialCommandGroup(new PrintCommand("5"),
      new PrintCommand("6"), new PrintCommand("7"), new PrintCommand("8"));
    }
    else{
    return null;
  }

    return m_autoCommand;
}
}