package frc.robot.commands;

import frc.robot.subsystems.ArmShooter;
import frc.robot.subsystems.Chassis;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class DriveTimed extends Command{

    Chassis _chassis;
    double _seconds;
    Timer timer = new Timer();
    double _turn;
    double _direction;

    // idk if name needs to get changed
    public DriveTimed(Chassis chassis, double turn, double direction,  double seconds)
    {
        _chassis = chassis;
        _seconds = seconds;
        _direction = direction;
        _turn = turn;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        timer.reset();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        timer.start();
        while(!timer.hasElapsed(_seconds))
        {
            _chassis.Drive(_turn, _direction);
        }
        timer.stop();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        _chassis.Drive(0, 0);
        timer.stop();
        System.out.println("interrupted");
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return timer.hasElapsed(_seconds);
    }

}
