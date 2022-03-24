// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Compresor extends SubsystemBase {
  private final Compressor myCompressor = new Compressor(PneumaticsModuleType.CTREPCM);
  public Compresor() {
  CompressorOff();
  }

  public void CompressorOn(){
    myCompressor.enableDigital();
  }

public void CompressorOff(){
    myCompressor.disable();
  }
  @Override
  public void periodic() {
    
  }
}
