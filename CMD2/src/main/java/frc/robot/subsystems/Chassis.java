// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
//Comunicación interna con otros archivos del proyecto
import frc.robot.Constants.DriveConstants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
//Importacion de librerias
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
//import com.ctre.phoenix.motorcontrol.InvertType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Encoder;

public class Chassis extends SubsystemBase {
  // Chassis Motors
  private final WPI_VictorSPX
  leftMaster = new WPI_VictorSPX(DriveConstants.kLeftMaster),
  rightMaster = new WPI_VictorSPX(DriveConstants.kRightMaster);
  //leftFollow = new WPI_VictorSPX(DriveConstants.kLeftFollow),
  //rightFollow = new WPI_VictorSPX(DriveConstants.kRightFollow);

  private Encoder leftEncoder = new Encoder(0, 1, DriveConstants.kLeftEncoderReversed, EncodingType.k4X);
  private Encoder rightEncoder = new Encoder(2, 3, DriveConstants.kLeftEncoderReversed, EncodingType.k4X);

  
  // The robot's drive
  private final DifferentialDrive DifferentialChassis = new DifferentialDrive(leftMaster, rightMaster);

  
  /** Creates a new ChassisSubsystem. */
  public Chassis() {
    configControllers();
    resetEncoders();
    // Configures the encoder's distance-per-pulse
    // The robot moves forward 6*PI inches per encoder rotation
    // There are 2048 pulses per encoder rotation
    leftEncoder.setDistancePerPulse((Units.inchesToMeters(6*Math.PI)) /2048);
    rightEncoder.setDistancePerPulse((Units.inchesToMeters(6*Math.PI)) /2048);
    // Configures the encoder to consider itself stopped after .1 seconds
    leftEncoder.setMaxPeriod(.1);
    rightEncoder.setMaxPeriod(.1);
    // Configures the encoder to consider itself stopped when its rate is below 10
    leftEncoder.setMinRate(10);
    rightEncoder.setMinRate(10);
    // Reverses the direction of the encoder
    //leftEncoder.setReverseDirection(true); //Ya declarado arriba
    //rightEncoder.setReverseDirection(true); //Ya declarado arriba
    // Configures an encoder to average its period measurement over 5 samples
    // Can be between 1 and 127 samples
    leftEncoder.setSamplesToAverage(5);
    rightEncoder.setSamplesToAverage(5);
    
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
    
    //Ponemos el electrofreno
    leftMaster.setNeutralMode(NeutralMode.Brake);
    rightMaster.setNeutralMode(NeutralMode.Brake);

    //Activamos seguridad
    leftMaster.setSafetyEnabled(true);
    rightMaster.setSafetyEnabled(true);
    //leftFollow.setSafetyEnabled(true);
    //rightFollow.setSafetyEnabled(true);
  }
  
  /** Reiniciamos los encoders para ponerlos a 0 */
  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  /**
   * Gets the average distance of the TWO encoders.
   *
   * @return the average of the TWO encoder readings
   */
  public double getAverageEncoderDistance() {
    return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2.0;
  }

  /**
   * Gets the left drive encoder.
   *
   * @return the left drive encoder
   */
public Encoder getLeftEncoder() {
    return leftEncoder;
  }

  /**
   * Gets the right drive encoder.
   *
   * @return the right drive encoder
   */
  public Encoder getRightEncoder() {
    return rightEncoder;
  }

  /**
   * Sets the max output of the drive. Useful for scaling the drive to drive more slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
    DifferentialChassis.setMaxOutput(maxOutput);
  }

  @Override
  public void periodic() {
    // Gets the distance traveled
    SmartDashboard.putNumber("Left Distance", leftEncoder.getDistance());
    SmartDashboard.putNumber("Left Rate", leftEncoder.getRate());
    SmartDashboard.putNumber("Right Distance", rightEncoder.getDistance());
    SmartDashboard.putNumber("Right Rate", rightEncoder.getRate());
  }
}