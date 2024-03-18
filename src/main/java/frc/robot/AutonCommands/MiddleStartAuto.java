package frc.robot.AutonCommands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.SubsystemCommands.DriveCommand;
import frc.robot.commands.ArmShootCommand;
import frc.robot.subsystems.ArmShooter;
import frc.robot.subsystems.Chassis;

public class MiddleStartAuto extends SequentialCommandGroup{
    final double shooterSpeed = 1;

    public MiddleStartAuto(Chassis chassis, ArmShooter shooter)
    {
        addCommands(
            new ParallelDeadlineGroup(new ArmShootCommand(shooter, shooterSpeed)).withTimeout(2),
            new ParallelDeadlineGroup(new DriveCommand(chassis, 1, 0).withTimeout(0.75)).withTimeout(2)
            
        );
    }
}
