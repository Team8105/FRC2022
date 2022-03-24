// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Chassis;

public class Drive extends CommandBase {
  private final Chassis chassis;

  /** Creates a new Drive. */
  public Drive(Chassis chassis) {
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
    double fwd = RobotContainer.ControlX.getRawAxis(1);
    double rot = RobotContainer.ControlX.getRawAxis(4);
    chassis.arcadeDrive(fwd, rot * 1);

    SmartDashboard.putNumber("Aceleracion Chassis: ", fwd);
    SmartDashboard.putNumber("Rotacion Chassis: ", rot);

  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    chassis.electrofreno();
    return false;
  }
}
