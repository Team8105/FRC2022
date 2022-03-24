// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Vision;


public class Track extends CommandBase {
  private final Chassis chassis;
  private final Vision vision;

  private final double kP = 0.05;


  /** Creates a new Track. */
public Track(Chassis chassis, Vision vision) {
    this.chassis = chassis;
    this.vision = vision;
    addRequirements(chassis, vision);
  }

  // Called when the command is initially scheduled.
  @Override
public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
public void execute() {
    vision.ledsOn();
    double errorX = 0 + vision.getX();
    double errorY = 0 + vision.getY();

    
    double fwd = errorY * 0.06; //Forward Speed
    double rot = errorX * kP;   //Rotation Speed

    chassis.arcadeDrive(fwd, rot);

    SmartDashboard.putNumber("Aceleracion Vision", fwd);
    SmartDashboard.putNumber("Giro Vision", rot);
  }

  // Called once the command ends or is interrupted.
  @Override
public void end(boolean interrupted) {
    chassis.arcadeDrive(0, 0);
    vision.ledsOff();
  }

  // Returns true when the command should end.
  @Override
public boolean isFinished() {
    return false;
  }
}