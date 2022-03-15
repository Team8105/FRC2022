// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//Librerias FIRST
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;

//Comunicacion entre archivos
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

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
  private final Conveyor conveyor = new Conveyor();
  private final Shooter shooter = new Shooter();
  private final Vision vision = new Vision();
  private final CompressorPepe compre = new CompressorPepe();

  public static XboxController ControlX = new XboxController(OIConstants.kControllerPort);
  
  //Comandos del robot
  private final Climb climb = new Climb(climber);
  private final Drive drive = new Drive(chassis);

  SendableChooser<String> autonomous = new SendableChooser<String>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    autonomous.addOption("Izquierda", "izquierda");
    autonomous.addOption("Centro", "centro");
    autonomous.addOption("Derecha", "derecha");
    autonomous.addOption("Linea", "linea");
    
    chassis.setDefaultCommand(drive);
    climber.setDefaultCommand(climb);
    
    // Configure the button bindings
    configureButtonBindings();
}

  private void configureButtonBindings() {

    //Mapeo de los botones
    new JoystickButton(ControlX, 5).whileHeld(new IntakeON(intake));
    new JoystickButton(ControlX, 5).whileHeld(new ConveyorON(conveyor));
    new JoystickButton(ControlX, 6).whileHeld(new ConveyorON(conveyor));
    new JoystickButton(ControlX, 6).whileHeld(new Shoot(shooter));
    new JoystickButton(ControlX, 1).whileHeld(new Track(chassis, vision));
    new JoystickButton(ControlX, 2 ).whenPressed(new DisparosChidos(shooter, conveyor));
    new JoystickButton(ControlX, 8).toggleWhenPressed(new OnOffCompressor(compre));
    new JoystickButton(ControlX, 7).toggleWhenPressed(new LimeLightLEDs(vision));
    
    
    //POV
    new POVButton(ControlX, 90).whileHeld(new EjectAll(conveyor, intake));
    //new POVButton(ControlX, 270).whenPressed(new Trucazo(shooter, conveyor, vision, chassis));
    //Este ultimo es el comando hat trick

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

  if(autonomous.getSelected() == "izquierda"){
    return new SequentialCommandGroup(new PrintCommand("1"),
    new PrintCommand("2"), new PrintCommand("3"), new PrintCommand("4"));
    
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

  }

}