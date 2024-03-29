package frc.robot.AutonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.SubsystemCommands.DriveCommand;
import frc.robot.subsystems.Chassis;

public class NonSpeakerStartAuto extends SequentialCommandGroup{
    
    public NonSpeakerStartAuto(Chassis chassis)
    {
        addCommands(
            new DriveCommand(chassis, 0, -.75).withTimeout(10)
        );
    }
}
