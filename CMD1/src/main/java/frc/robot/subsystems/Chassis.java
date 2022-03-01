// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.chassis;

public class Chassis extends SubsystemBase {
  WPI_VictorSPX mIzquierdo = new WPI_VictorSPX(chassis.portMotors[0]);
  WPI_VictorSPX mDerecho = new WPI_VictorSPX(chassis.portMotors[1]);
  DifferentialDrive myChassis = new DifferentialDrive(mDerecho, mIzquierdo);
  
  /** Creates a new Chassis. */
  public Chassis() {
    mDerecho.configFactoryDefault();
    mIzquierdo.configFactoryDefault();

    mIzquierdo.setNeutralMode(NeutralMode.Brake);
    mDerecho.setNeutralMode(NeutralMode.Brake);

    mDerecho.setInverted(true);
  }
  public void drive(double X, double Y){
    myChassis.arcadeDrive(X, Y);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}