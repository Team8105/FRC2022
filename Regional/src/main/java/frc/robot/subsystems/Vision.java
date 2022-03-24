// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;

public class Vision extends SubsystemBase {
  public static UsbCamera CamaraUSB = CameraServer.startAutomaticCapture(0);
  private static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private NetworkTable table2 = NetworkTableInstance.getDefault().getTable("CameraPublisher").getSubTable("limelight");
  private NetworkTableEntry tx = table.getEntry("tx");
  private NetworkTableEntry ty = table.getEntry("ty");
  private NetworkTableEntry ta = table.getEntry("ta");
  private NetworkTableEntry tv = table.getEntry("tv");
  private NetworkTableEntry available = table2.getEntry("description");

  private boolean availableCamera = false;

  /** Creates a new Vision. */
  public Vision() {
  ledsOff();
	CamaraUSB.setResolution(120, 160); //60,80
  CamaraUSB.setFPS(24);
  CamaraUSB.setBrightness(50);
  CamaraUSB.setExposureManual(50);


  }

public boolean availableLimeLight(){
    String name = available.getString(null);
    
    try {
      if(name.length() > 0)
      return true;
    else 
      return false;  
    } catch (Exception e) {
      return false;
    } 
  }

public double getX() {
    return tx.getDouble(0.0);
  }

public double getY() {
    return ty.getDouble(0.0);
  }

public double getArea() {
    return ta.getDouble(0.0);
  }
public boolean availableTarget() {
    if (tv.getDouble(0.0) > 0)
      return true;
    else
      return false;
  }

public void ledsOff() {
    table.getEntry("ledMode").setNumber(1);
  }

public void ledsOn() {
    table.getEntry("ledMode").setNumber(3);
  }

public void blinkLeds() {
    table.getEntry("ledMode").setNumber(2);
  }

public void blinkLeds2() {
    table.getEntry("ledMode").setNumber(6);
  }

public static void ledsDefault() {
    table.getEntry("ledMode").setNumber(0);
  }

  @Override
public void periodic() {
    SmartDashboard.putNumber("tX", getX());
    SmartDashboard.putNumber("tY", getY());
    SmartDashboard.putBoolean("targetVisible", availableTarget());

    if(availableLimeLight() && !availableCamera){
      availableCamera = true;
      ledsOff();
    }
  }
}
