// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vision extends SubsystemBase {
  private static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  //private NetworkTable table2 = NetworkTableInstance.getDefault().getTable("Camera");
  private NetworkTableEntry tx = table.getEntry("tx");
  private NetworkTableEntry ty = table.getEntry("ty");

  public Vision() {}

  public double getX(){
    return tx.getDouble(0.0);
  }

  public double getY(){
    return ty.getDouble(0.0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("X", getX());
    SmartDashboard.putNumber("Y", getY());
  }
}
