// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Constants.kClimber; kClimber.kPiston1Ports[0,1]

public class Climber extends SubsystemBase {
  // Shooter Motors
  private final DoubleSolenoid
  leftPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0,2),
  rightPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1,3);

  /** Creates a new Climber. */
  public Climber() {
    Config();
  }

  public void Extend() {
    leftPiston.set(DoubleSolenoid.Value.kForward);
    rightPiston.set(DoubleSolenoid.Value.kForward);
  }
  public void Config() {
    leftPiston.set(DoubleSolenoid.Value.kReverse);
    rightPiston.set(DoubleSolenoid.Value.kReverse);
  }
  public void Contract() {
    leftPiston.set(DoubleSolenoid.Value.kReverse);
    rightPiston.set(DoubleSolenoid.Value.kReverse);
  }
  public void Off() {
    leftPiston.set(DoubleSolenoid.Value.kOff);
    rightPiston.set(DoubleSolenoid.Value.kOff);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
