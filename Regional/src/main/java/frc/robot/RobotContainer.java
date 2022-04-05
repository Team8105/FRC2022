// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//Librerias FIRST
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;

//Comunicacion entre archivos
import frc.robot.Constants.OIConstants;
import frc.robot.autos.Linea;
import frc.robot.autos.Precargada;
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
  private final Compresor compresor = new Compresor();
  private final Conveyor conveyor = new Conveyor();
  private final Chassis chassis = new Chassis();
  private final Climber climber = new Climber();
  private final Shooter shooter = new Shooter();
  private final Vision vision = new Vision();
  private final Intake intake = new Intake();


  public static XboxController ControlX = new XboxController(OIConstants.kControllerPort);
  
  //Comandos del robot
  private final Climb climb = new Climb(climber);
  private final Drive drive = new Drive(chassis);
//  private final lowerShoot lowershoot = new lowerShoot(shooter);

  SendableChooser<String> autonomous = new SendableChooser<String>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    autonomous.addOption("Precargada", "precargada");
    autonomous.addOption("Linea", "linea");

    SmartDashboard.putData("Auto Mode:", autonomous);
    
    chassis.setDefaultCommand(drive);
    climber.setDefaultCommand(climb);
    //shooter.setDefaultCommand(new lowerShoot(shooter));

    
    // Configure the button bindings
    configureButtonBindings();
}

  private void configureButtonBindings() {

    //Mapeo de los botones
    new JoystickButton(ControlX, OIConstants.kCompressorButton).toggleWhenPressed(new CompresorOnOff(compresor));
    new JoystickButton(ControlX, OIConstants.kEjectButton).whileHeld(new EjectAll(conveyor, intake, shooter)); //A
    new JoystickButton(ControlX, OIConstants.kCollectButton).whileHeld(new ConveyorON(conveyor));
    new JoystickButton(ControlX, OIConstants.kCollectButton).whileHeld(new IntakeON(intake));
    new JoystickButton(ControlX, OIConstants.kShootButton).whileHeld(new Shoot(shooter)); // Disparo duro
    //new JoystickButton(ControlX, 2).whileHeld(new lowerShoot(shooter)); // B Disparo suave


    new JoystickButton(ControlX, 8).whileHeld(new Track(chassis, vision));
    //new JoystickButton(ControlX, OIConstants.kSuperButton).whenPressed(new SUPER(shooter, conveyor, vision, chassis));
    //new JoystickButton(ControlX, 4).whenPressed(new SUPER(shooter, conveyor, vision, chassis));

}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

  if(autonomous.getSelected() == "precargada"){
    return new Precargada(shooter, conveyor, vision, chassis);
    
  }
    else if(autonomous.getSelected() == "linea"){
      return new Linea(chassis, shooter);
    }


    else{ // Cerramos el bucle selector de autonomo sin respuesta
      return new Linea(chassis, shooter);
    }

  }

}