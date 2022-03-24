// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

public class AutoDrive extends CommandBase {
  private final Chassis chassis;
  private final double fwd, rot;

  /** Creates a new Drive. */
  public AutoDrive(Chassis chassis, double fwd, double rot){
    this.chassis = chassis;
    this.fwd = fwd;
    this.rot = rot;
    addRequirements(this.chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    chassis.arcadeDrive(fwd, rot * 1);
    //De reversa mami
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
