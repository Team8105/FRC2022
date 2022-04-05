// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Vision;

public class LimeLightLEDs extends CommandBase {
  private final Vision vision;

  
  public LimeLightLEDs(Vision vision) {
  this.vision = vision;
  addRequirements(vision);  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    vision.ledsOn();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    vision.ledsOn();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    vision.ledsOn();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}