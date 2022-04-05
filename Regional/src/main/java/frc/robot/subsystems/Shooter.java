// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
//Comunicación entre archivos
import frc.robot.Constants.ShooterConstants;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
//Librerias
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  // Shooter Motors
  private final VictorSP
  mRightShooter = new VictorSP(ShooterConstants.kRightShooterPort),
  mLeftShooter = new VictorSP(ShooterConstants.kLeftShooterPort);

  //private final DifferentialDrive DifferentialShooter = new DifferentialDrive(mLeftShooter, mRightShooter);

  /** Creates a new Shooter. */
  public Shooter() {
    mLeftShooter.setInverted(true);
    
    mRightShooter.setInverted(false);
    
  }

public void Activate(){
    mLeftShooter.setVoltage(12);
    mRightShooter.setVoltage(12);
  
  }

public void softActivate(double x){
  mLeftShooter.setVoltage(x);
  mRightShooter.setVoltage(x);

}
  
public void Stop() {
  mLeftShooter.setVoltage(0);
  mRightShooter.setVoltage(0);

  
  }
public void ejectShooter(){
  mLeftShooter.setVoltage(-6);
  mRightShooter.setVoltage(-6);

}

  public void Run(double x) {
    mLeftShooter.setVoltage(x);
    mRightShooter.setVoltage(x);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}