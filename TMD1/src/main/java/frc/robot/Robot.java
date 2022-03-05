// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
//import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  //Autonomous settings
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  private final Compressor paps = new Compressor(PneumaticsModuleType.CTREPCM);
  //Initialize motors
  WPI_VictorSPX MotorDF = new WPI_VictorSPX(4); //Chassis
  WPI_VictorSPX MotorIF = new WPI_VictorSPX(5); //Chassis
  WPI_VictorSPX Disparador = new WPI_VictorSPX(6); //Disparador
  WPI_VictorSPX Disparador2 = new WPI_VictorSPX(7); //Disparador2
  VictorSP Intake = new VictorSP(2); //Intake
  VictorSP Intake2 = new VictorSP(3); //Intake
  //VictorSP Disparador2 = new VictorSP(2);

  //Initialize teleop settings
  DifferentialDrive Chassis = new DifferentialDrive(MotorIF, MotorDF);
  XboxController ControlX = new XboxController(0);

  //Initialize Pneumatics
  private final DoubleSolenoid Piston1 =
  new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 2);

  private final DoubleSolenoid Piston2 =
  new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 3);
  
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    MotorDF.setInverted(true);
    Disparador2.setInverted(true);
    paps.disable();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {

  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {//AXIS 2= REVERSA 3 = ADELANTE
    double avanzar = ControlX.getRawAxis(1);
    double girar = +1 * ControlX.getRawAxis(2);

    /* deadband gamepad 10% */
    if (Math.abs(avanzar) < 0.10) {
    avanzar = 0;
    }
    if (Math.abs(girar) < 0.10) {
    girar = 0;
    }
    Chassis.arcadeDrive(avanzar, girar);

    //Operaciones con botones
    
    //Recoger
    if(ControlX.getRawButton(7)){//Recoger
      Intake.set(1);
      Intake2.set(0.5);
    } else if(ControlX.getRawButton(6)){ //Disparar
      Disparador.set(1);
      Disparador2.set(1);
    } else if(ControlX.getRawButton(1)){ //Expulsar
    Intake.set(-1);
    Intake2.set(-0.5);
    }
    else{
    Intake.set(0);
    Intake2.set(0);
    Disparador2.set(0);
    Disparador.set(0);
  }
  
  if(ControlX.getRawButton(4)) { //Boton para subir = Y
    Piston1.set(DoubleSolenoid.Value.kReverse);
    Piston2.set(DoubleSolenoid.Value.kReverse);
  } else{
    Piston1.set(DoubleSolenoid.Value.kOff);
    Piston2.set(DoubleSolenoid.Value.kOff);
  }
  if (ControlX.getRawButton(3)){
    Piston1.set(DoubleSolenoid.Value.kForward); //Boton para bajar = B
    Piston2.set(DoubleSolenoid.Value.kForward);
  }
  
    //SmartDashboard.putNumber("Speed", ControlX.getRawAxis(3)-ControlX.getRawAxis(2));
}

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {

  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {

  }

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {

  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {

  }
}