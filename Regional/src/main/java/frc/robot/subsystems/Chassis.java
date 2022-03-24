// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
//Comunicación interna con otros archivos del proyecto
import frc.robot.Constants.ChassisConstants;

//Importacion de librerias
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.InvertType;
//Librerias de FIRST
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.PrintCommand;


public class Chassis extends SubsystemBase {
  // Chassis Motors
  private final WPI_VictorSPX
  leftMaster = new WPI_VictorSPX(ChassisConstants.kLeftMaster),     rightMaster = new WPI_VictorSPX(ChassisConstants.kRightMaster),
  leftFollower = new WPI_VictorSPX(ChassisConstants.kLeftFollower), rightFollower = new WPI_VictorSPX(ChassisConstants.kRightFollower);
  
  // The robot's drive
  private final DifferentialDrive DifferentialChassis = new DifferentialDrive(leftMaster, rightMaster);

  
  /** Creates a new ChassisSubsystem. */
  public Chassis() {
    configControllers();

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
    leftFollower.configFactoryDefault();
    rightFollower.configFactoryDefault();
    
    //Invertimos
    leftMaster.setInverted(false);
    rightMaster.setInverted(true);
    leftFollower.setInverted(InvertType.FollowMaster);
    rightFollower.setInverted(InvertType.FollowMaster);
    
    //Establecemos followers
    leftFollower.follow(leftMaster);
    rightFollower.follow(rightMaster);
    
    //Ponemos el electrofreno
    leftMaster.setNeutralMode(NeutralMode.Brake);
    rightMaster.setNeutralMode(NeutralMode.Brake);
    leftFollower.setNeutralMode(NeutralMode.Brake);
    rightFollower.setNeutralMode(NeutralMode.Brake);
    
  }

public void electrofreno(){
        //Funcion para quitar el electrofreno
        leftMaster.setNeutralMode(NeutralMode.Coast);
        rightMaster.setNeutralMode(NeutralMode.Coast);
        leftFollower.setNeutralMode(NeutralMode.Coast);
        rightFollower.setNeutralMode(NeutralMode.Coast);
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
    
  }
}