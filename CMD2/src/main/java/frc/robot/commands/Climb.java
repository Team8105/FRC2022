// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Climber;

public class Climb extends CommandBase {
  private final Climber climber;

  /** Creates a new Climb. */
  public Climb(Climber climber) {
    this.climber = climber;
    addRequirements(this.climber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    climber.Config();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  switch (RobotContainer.ControlX.getPOV()) {
      case 0:
      climber.Extend();
      break;
      
      case 180:
      climber.Contract();
        break;
    
      default:
        climber.Off();
        break;
    }
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
