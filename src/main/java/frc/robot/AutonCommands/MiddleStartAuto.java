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
            new DriveCommand(chassis, 0, -.65).withTimeout(.5),
            new ArmShootCommand(shooter, shooterSpeed).withTimeout(1),
            new DriveCommand(chassis, 0, -.65).withTimeout(2)
            
        );
        // should shoot, then either go straight or veer slightly right then left
    }
}
