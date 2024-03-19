package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hanger;
import frc.robot.SubsystemCommands.HangCommand;

public class HangDefaultCommand extends Command {
    
    Hanger _hanger;
    Joystick _joystick;

    public HangDefaultCommand(Hanger _hanger, Joystick _controller) {
        this._hanger = _hanger;
        _joystick = _controller;
        addRequirements(_hanger);
    }

    @Override
    public void execute()
    {
        if(_joystick.getPOV() == CommandConstants.PovUp)
        {
            HangCommand _command = new HangCommand(_hanger, 0.65);
            _command.execute();
        }
        else if(_joystick.getPOV() == CommandConstants.PovDown)
        {
            HangCommand _command = new HangCommand(_hanger, -0.5);
            _command.execute();
        }
        else
        {
            _hanger.stop();
        }
    }
}
