package frc.robot.AutonCommands;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.SubsystemCommands.DriveCommand;
import frc.robot.commands.ArmShootCommand;
import frc.robot.subsystems.ArmShooter;
import frc.robot.subsystems.Chassis;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;

public class LeftStartAuto extends SequentialCommandGroup{

    final double shooterSpeed = 1;

    public LeftStartAuto(Chassis chassis, ArmShooter shooter)
    {
        addCommands(
            new ParallelDeadlineGroup(new ArmShootCommand(shooter, shooterSpeed)).withTimeout(1),
            new ParallelDeadlineGroup(new DriveCommand(chassis, 0, 1).withTimeout(1))
            
        );
    }
}
