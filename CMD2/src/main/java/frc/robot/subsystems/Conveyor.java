// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Conveyor extends SubsystemBase {
  /* Conveyor Motors*/
  private final VictorSP
  mConveyor = new VictorSP(IntakeConstants.kConveyorPort);

  public Conveyor() {
  mConveyor.setInverted(IntakeConstants.kConveyorInvert);

  }
  public void ActivateConveyor(){
    mConveyor.setVoltage(IntakeConstants.kConveyorVolt);
  }
  public void ActivateConveyorSuave(){
    mConveyor.set(1);
  }
  public void StopConveyor() {
    mConveyor.setVoltage(0);
  }
  
  public void ejectConveyor(){
    mConveyor.setVoltage(-11);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}