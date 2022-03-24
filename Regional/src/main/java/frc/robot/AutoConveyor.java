// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor;

public class AutoConveyor extends CommandBase {
  private final Conveyor conveyor;
  private final double x;

  /** Creates a new Drive. */
  public AutoConveyor(Conveyor conveyor, double x){
    this.conveyor = conveyor;
    this.x = x;
    addRequirements(this.conveyor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    conveyor.Run(x * 1);
    //De reversa mami
  }

  @Override
  public void end(boolean interrupted) {
    conveyor.Run(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
