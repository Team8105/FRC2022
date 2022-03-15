// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants.IntakeConstants;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  // Intake Motors
  private final VictorSP
  mIntake = new VictorSP(IntakeConstants.kIntakePort);

  /** Creates a new Intake. */
  public Intake() {
    mIntake.setInverted(IntakeConstants.kIntakeInvert);
  }
  public void ActivateIntake(){
    mIntake.setVoltage(IntakeConstants.kIntakeVolt);
  }

  public void StopIntake() {
    mIntake.setVoltage(0);
  }
  
  public void ejectIntake(){
    mIntake.setVoltage(-12);
  }

  public void periodic() {
    // This method will be called once per scheduler run
  }

}