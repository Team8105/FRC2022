// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//Comunicación entre archivos
import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//Librerias FIRST
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  //Intake Motors
  private final VictorSP
  mIntake = new VictorSP(IntakeConstants.kIntakePort);
  //Intake Piston
  private final DoubleSolenoid
  intakePiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4, 5);

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

public void extendIntake(){
  intakePiston.set(Value.kForward);
  }

public void contractIntake(){
  intakePiston.set(Value.kReverse);
  }

public void intakePistonOff(){
  intakePiston.set(Value.kOff);
  }

public void periodic() {
    // This method will be called once per scheduler run
  }

}