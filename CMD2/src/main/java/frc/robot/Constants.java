// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class DriveConstants {
    public static final int
    kLeftMaster = 5, kRightMaster = 4,
    kLeftFollow = 51, kRightFollow = 41;

    public static final int[] kLeftEncoderPorts = new int[] {0, 1};
    public static final int[] kRightEncoderPorts = new int[] {2, 3};
    public static final boolean kLeftEncoderReversed = false;
    public static final boolean kRightEncoderReversed = false;

    public static final int kEncoderCPR = 2048;
    public static final double kWheelDiameterInches = 6;
    public static final double kEncoderDistancePerPulse =
  // Assumes the encoders are directly mounted on the wheel shafts (ours are mounted on a gearbox)
        (kWheelDiameterInches * Math.PI) / kEncoderCPR;
  }

  public static final class kClimber{
    public static final int kPneumaticsModule = 0;
    public static final int[] kPiston1Ports = new int[] {0, 2},
                              kPiston2Ports = new int[] {1, 3};
  }

  public static final class ShooterConstants{
    public static final int
    kShooterRightPort = 6, kShooterLeftPort = 7;
    
    public static final double
    kShooterLeftVolt = 11.5, kShooterRightVolt = 11.5; 

  }

  public static final class IntakeConstants{
    public static final boolean 
    kConveyorInvert = false, kIntakeInvert = false;

    public static final int
    kIntakePort = 1, kConveyorPort = 2;
    
    public static final double
    kIntakeVolt = 12, kConveyorVolt = 12;
  }

  public static final class AutoConstants {
    public static final double kAutoDriveDistanceInches = 60;
    public static final double kAutoBackupDistanceInches = 20;
    public static final double kAutoDriveSpeed = 0.5;
  }

  public static final class OIConstants {
    public static final int kControllerPort = 0;
  }
}