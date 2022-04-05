// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

public class Drive2 extends CommandBase {
  private final Chassis chassis;

  /** Creates a new Drive. */
  public Drive2(Chassis chassis) {
    this.chassis = chassis;
    addRequirements(this.chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    chassis.arcadeDrive(0.55, 0 * 1);
  }

  @Override
  public void end(boolean interrupted) {
    chassis.arcadeDrive(0, 0 * 1);

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
