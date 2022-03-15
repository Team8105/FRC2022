// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;
//Comunicación entre archivos
import frc.robot.Constants.ShooterConstants;
//Librerias
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  // Shooter Motors
  private final WPI_VictorSPX
  mShooterRight = new WPI_VictorSPX(ShooterConstants.kShooterRightPort),
  mShooterLeft = new WPI_VictorSPX(ShooterConstants.kShooterLeftPort);

  private double topSpeed = 0.2,
  currentSpeed = 0, increment = 0.05;

  /** Creates a new Shooter. */
  public Shooter() {
    mShooterRight.configFactoryDefault();
    mShooterRight.setInverted(false);
    
    mShooterLeft.configFactoryDefault();
    mShooterLeft.setInverted(true);

  }
  public void Activate(){ //Método que activa el disparador

    if(currentSpeed < topSpeed){ //Condicional usada para subir suavemente aceleración
    currentSpeed += increment;
    }
    mShooterLeft.setVoltage(Constants.ShooterConstants.kShooterLeftVolt);
    mShooterRight.setVoltage(Constants.ShooterConstants.kShooterRightVolt);
  }
  
  public void Stop() {
    currentSpeed = 0;
    mShooterLeft.setVoltage(0);
    mShooterRight.setVoltage(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}