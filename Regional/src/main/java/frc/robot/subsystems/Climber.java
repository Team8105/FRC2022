// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
  // Climber' Components
  private final DoubleSolenoid
  bigPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1),
  miniPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
 
  /** Creates a new Climber. */
public Climber(){
  //Off();
  }

public void contractBig() {
  bigPiston.set(DoubleSolenoid.Value.kForward);
}

public void contractMini() {
  miniPiston.set(DoubleSolenoid.Value.kReverse);
}

public void extendBig() {
  bigPiston.set(DoubleSolenoid.Value.kReverse);
  }

public void extendMini() {
    miniPiston.set(DoubleSolenoid.Value.kForward);
  }

public void Off() {
    bigPiston.set(DoubleSolenoid.Value.kOff);
    miniPiston.set(DoubleSolenoid.Value.kOff);
  }



  @Override
public void periodic() {
    // This method will be called once per scheduler run
  }
}