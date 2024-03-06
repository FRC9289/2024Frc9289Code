package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class TimedCommand extends Command {

    double _seconds;
    Timer timer;
    Command _command;

    public TimedCommand (Command command, double seconds)
    {
        _seconds = seconds;
        _command = command;
        timer = new Timer();
    }

    @Override
    public void initialize() {
        _command.initialize();
        timer.reset();
    }

    // runs command for set number of seconds
    @Override
    public void execute() {
        timer.start();

        while(!timer.hasElapsed(_seconds))
        {
            _command.execute();
        }
    
    }

    @Override
    public void end(boolean interrupted)
    {
        _command.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return _command.isFinished();
    }

    
}
