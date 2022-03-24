// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subroutines;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.Track;
import frc.robot.subsystems.*;
import frc.robot.AutoConveyor;
import frc.robot.AutoShoot;

// ESTE COMANDO REALIZA TODAS LAS INSTRUCCIONES
// PARA ALINEARSE Y DISPARAR EN TELEOPERADO

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SUPER extends ParallelCommandGroup {
  /** Creates a new SUPER. */
  public SUPER(Shooter shooter, Conveyor conveyor, Vision vision, Chassis chassis) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
    new SequentialCommandGroup(
            new Track(chassis, vision).withTimeout(6)       //Se alinea constantemente
    ),

    new SequentialCommandGroup(
            new AutoShoot(shooter, -1).withTimeout(1),      // Activa el disparador -100% por 1 segundo
            new AutoConveyor(conveyor, -1).withTimeout(1),  // Activa conveyor -100% por 1 segundo
            new WaitCommand(3),                             // Delay para recargar motores
            new AutoConveyor(conveyor, 1).withTimeout(1),   // Activa conveyor 100% por 1 segundo
            new WaitCommand(3),                             // Delay para recargar motores
            new AutoConveyor(conveyor, 1).withTimeout(1)    // Ultima pelota
    ),

    new SequentialCommandGroup(
            new WaitCommand(2.5),                           // Delay usado para evitar sistemas choke
            new AutoShoot(shooter, 1).withTimeout(6)        // Enciende el disparador 6 segundos
    )

    );
  }
}
