// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
//Comunicación interna con otros archivos del proyecto
import frc.robot.Constants.DriveConstants;

//Importacion de librerias
//import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.Encoder;

public class Chassis extends SubsystemBase {
  // Chassis Motors
  private final WPI_VictorSPX
  leftMaster = new WPI_VictorSPX(DriveConstants.kLeftMaster),
  rightMaster = new WPI_VictorSPX(DriveConstants.kRightMaster);
  //leftFollow = new WPI_VictorSPX(DriveConstants.kLeftFollow),
  //rightFollow = new WPI_VictorSPX(DriveConstants.kRightFollow);



  // The robot's drive
  private final DifferentialDrive DifferentialChassis = new DifferentialDrive(leftMaster, rightMaster);
/*
  // The left-side drive encoder
  private final Encoder leftEncoder =
      new Encoder(
          DriveConstants.kLeftEncoderPorts[0],
          DriveConstants.kLeftEncoderPorts[1],
          DriveConstants.kLeftEncoderReversed);

  // The right-side drive encoder
  private final Encoder rightEncoder =
      new Encoder(
          DriveConstants.kRightEncoderPorts[0],
          DriveConstants.kRightEncoderPorts[1],
          DriveConstants.kRightEncoderReversed);
*/
  /** Creates a new ChassisSubsystem. */
  public Chassis() {
    configControllers();
    
    // Sets the distance per pulse for the encoders
    //leftEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);
    //rightEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);
    new PrintCommand("Hola");
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {
    DifferentialChassis.arcadeDrive(fwd, rot);
  }

  private void configControllers(){
    //Default de controladores
    leftMaster.configFactoryDefault();
    rightMaster.configFactoryDefault();
    //leftFollow.configFactoryDefault();
    //rightFollow.configFactoryDefault();
    
    //Invertimos
    leftMaster.setInverted(false);
    rightMaster.setInverted(true);
    //leftFollow.setInverted(InvertType.FollowMaster);
    //rightFollow.setInverted(InvertType.FollowMaster);
    
    //Establecemos followers
    //leftFollow.follow(leftMaster);
    //rightFollow.follow(rightMaster);
  }

  /** Reiniciamos los encoders para ponerlos a 0 */
  public void resetEncoders() {
    //leftEncoder.reset();
    //rightEncoder.reset();
  }

  /**
   * Gets the average distance of the TWO encoders.
   *
   * @return the average of the TWO encoder readings
   */
/*  public double getAverageEncoderDistance() {
    return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2.0;
  }*/

  /**
   * Gets the left drive encoder.
   *
   * @return the left drive encoder
   */
/*public Encoder getLeftEncoder() {
    return leftEncoder;
  }*/

  /**
   * Gets the right drive encoder.
   *
   * @return the right drive encoder
   */
/*  public Encoder getRightEncoder() {
    return rightEncoder;
  }*/

  /**
   * Sets the max output of the drive. Useful for scaling the drive to drive more slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
    DifferentialChassis.setMaxOutput(maxOutput);
  }
}