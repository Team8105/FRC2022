// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.IntakeConstants;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  // Chassis Motors
  private final VictorSP
  mIntake = new VictorSP(IntakeConstants.kIntake),
  mConveyor = new VictorSP(IntakeConstants.kConveyor);

  private double intakeSpeed = 1;

  /** Creates a new Intake. */
  public Intake() {
    mIntake.setInverted(false);
    mConveyor.setInverted(false);

  }
  public void TakeBall(){
    mIntake.set(intakeSpeed);
    mConveyor.set(intakeSpeed);
  }

  public void Stop() {
    mIntake.set(0);
    mConveyor.set(0);
  }

  public void shootAuto(){
    double shootSpeed = 0.25;
    
    mIntake.set(shootSpeed);
    mConveyor.set(shootSpeed);
  }
  
  public void ejectBall(){
    mIntake.set(-1);
    mConveyor.set(-1);
  }

  public void periodic() {
    // This method will be called once per scheduler run
  }

}
