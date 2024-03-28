package frc.robot.AutonCommands;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.SubsystemCommands.ArmShootCommand;
import frc.robot.subsystems.ArmShooter;
import frc.robot.subsystems.Chassis;



public class AutoDrive extends Command {

    Chassis _chassis;
    ArmShootCommand _ShootCommand;
    ArmShooter _ArmShooter;
    ArmShooter _shooter;
    Timer shooterTimer = new Timer();
    Timer autonTimer = new Timer();
    // Timer timer;


    public AutoDrive(Chassis chassis)
    {
        _chassis = chassis;
        _ShootCommand = null;
    }

    public AutoDrive(Chassis chassis, ArmShooter _ArmShooter) {
        _chassis = chassis;
        _ShootCommand = new ArmShootCommand(_ArmShooter);
        addRequirements(_chassis);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        // timer.reset();
        // timer.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        autonTimer.reset();
        autonTimer.restart();
        autonTimer.start();

        while (!autonTimer.hasElapsed(2)){
            _chassis.Drive(0, 1);
        }

        autonTimer.stop();
        autonTimer.reset();
        autonTimer.restart();
        autonTimer.start();

        while (!autonTimer.hasElapsed(3)){
            _chassis.Drive(0, -1);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        _chassis.Drive(0, 0);
        System.out.println("interrupted");
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return autonTimer.hasElapsed(0.5);
    }

}
