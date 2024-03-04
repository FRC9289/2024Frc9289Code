package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmShooter;

public class ArmShooterDefaultCommand extends Command {

    ArmShooter _shooter;
    Joystick _joystick;

    public ArmShooterDefaultCommand(ArmShooter shooter, Joystick _controller) {
        _shooter = shooter;
        _joystick = _controller;
        addRequirements(_shooter);
    }

    @Override
    public void execute() {
        
        if(_joystick.getRawAxis(3) > 0)
        {
            ArmShootCommand _command = new ArmShootCommand(_shooter, 1.5, "A");
            _command.execute();
        }
        else if(_joystick.getRawAxis(2) > 0)
        {
            ArmShootCommand _command = new ArmShootCommand(_shooter, -0.25);
            _command.execute();
        }
        else if(_joystick.getRawButton(6))  
        {
            ArmShootCommand _command = new ArmShootCommand(_shooter, 0.35);
            _command.execute();
        }
        else if(_joystick.getRawButton(3))
        {
            ArmShootCommand _Command = new ArmShootCommand(_shooter, 1.5, "B");
            _Command.execute();
        }
        else{
            ArmShootCommand _command = new ArmShootCommand(_shooter, 0);
            _command.execute();

        }
    }

}