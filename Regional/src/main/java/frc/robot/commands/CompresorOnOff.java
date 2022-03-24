// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Compresor;

public class CompresorOnOff extends CommandBase {
  private final Compresor compresor;
  public CompresorOnOff(Compresor compresor) {
    this.compresor = compresor;
    addRequirements(this.compresor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    compresor.CompressorOff();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  compresor.CompressorOn();
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    compresor.CompressorOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
