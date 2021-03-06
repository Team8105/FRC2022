// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class EjectAll extends CommandBase {
  private final Conveyor conveyor;
  private final Intake intake;
  private final Shooter shooter;

  public EjectAll(Conveyor conveyor, Intake intake, Shooter shooter) {
    this.conveyor = conveyor;
    this.intake = intake;
    this.shooter = shooter;
    addRequirements(conveyor, intake, shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    conveyor.ejectConveyor();
    intake.ejectIntake();
    shooter.ejectShooter();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    conveyor.StopConveyor();
    intake.StopIntake();
    shooter.Stop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
