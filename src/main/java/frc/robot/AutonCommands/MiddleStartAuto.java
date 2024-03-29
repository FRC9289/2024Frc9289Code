package frc.robot.AutonCommands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.SubsystemCommands.ArmShootCommand;
import frc.robot.SubsystemCommands.DriveCommand;
import frc.robot.subsystems.ArmShooter;
import frc.robot.subsystems.Chassis;

public class MiddleStartAuto extends SequentialCommandGroup{
    final double shooterSpeed = 1;

    public MiddleStartAuto(Chassis chassis, ArmShooter shooter)
    {
        addCommands(
            new ArmShootCommand(shooter, shooterSpeed).withTimeout(1),
            new DriveCommand(chassis, 0, 1).withTimeout(3)
            
        );
        // should shoot, then either go straight or veer slightly right then left
    }
}
