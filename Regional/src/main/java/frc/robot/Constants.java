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
  public static final class ChassisConstants {
    public static final int
    kLeftMaster = 1, kRightMaster = 3,
    kLeftFollower = 2, kRightFollower = 4;

    public static final int[] kLeftEncoderPorts = new int[] {0, 1};
    public static final int[] kRightEncoderPorts = new int[] {2, 3};
    public static final boolean kLeftEncoderReversed = false;
    public static final boolean kRightEncoderReversed = false;

    public static final int kEncoderCPR = 2048;
    public static final double kWheelDiameterInches = 6;
    public static final double kEncoderDistancePerPulse =
    //Assumes the encoders are directly mounted on the chassis gearbox
        (kWheelDiameterInches * Math.PI) / kEncoderCPR;
  }

  public static final class ClimberConstants{
    public static final int kPneumaticsModule = 0;
    public static final int[] kBigPistonPort = new int[] {0, 2},
                              kMiniPistonPort = new int[] {1, 3};
}

public static final class IntakeConstants{
    public static final boolean 
    kConveyorInvert = true, kIntakeInvert = false;
    
    public static final int
    kIntakePort = 1, kConveyorPort = 2; //IMPORTANTEEE
    
    public static final double
    kIntakeVolt = 8, kConveyorVolt = 12,
    kIntakeSpeed = 1, kConveyorSpeed = 1;
}

public static final class ShooterConstants{
    public static final int
    kRightShooterPort = 0, kLeftShooterPort = 3; //IMPORTANTEEE
    
    public static final double
    kShooterSpeed = 1;
}


  public static final class AutoConstants {
    public static final double kAutoDriveDistanceInches = 60;
    public static final double kAutoBackupDistanceInches = 20;
    public static final double kAutoDriveSpeed = 0.5;
  }
  /* Here we declare our buttons mappings and the Xbox controller port
   * If needed you can change here the button's ID to do some other thing.
   * kCollectButton = Boton que activa el intake
   * kShootButton = Boton que activa el disparador
   * kConveyorButton =  Boton que activa el conveyor
   * kLEDsButton = Boton que enciende los LEDs de la LimeLight
  */
  public static final class OIConstants {
    public static final int kControllerPort = 0,
    kCollectButton = 5, kShootButton = 6,
    kEjectButton = 1, kCompressorButton = 7,
    kShootsButton = 6, kLEDsButton = 8,
    kSuperButton = 2;
  }
}