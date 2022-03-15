// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
//import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DisparosChidos extends ParallelCommandGroup {
  /** Creates a new DisparosChidos. */
  public DisparosChidos(Shooter shooter, Conveyor conveyor) {
    
    // Add your commands in the addCommands() call, e.g. 3.6
    // addCommands(new FooCommand(), new BarCommand());
      addCommands(
        new SequentialCommandGroup(new WaitCommand(0.3), new Shoot(shooter).withTimeout(8)),
        new SequentialCommandGroup(new ConveyorOut(conveyor).withTimeout(0.1), new WaitCommand(3), new ConveyorON(conveyor).withTimeout(0.15), new WaitCommand(3), new ConveyorON(conveyor).withTimeout(0.3))
      );
  }
  
}