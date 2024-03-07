package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmShooter;

public class ArmShooterDefaultCommand extends Command {

    ArmShooter _shooter;
    Joystick _joystick;
    Timer shooterTimer = new Timer();

    public ArmShooterDefaultCommand(ArmShooter shooter, Joystick _controller) {
        _shooter = shooter;
        _joystick = _controller;
        addRequirements(_shooter);
    }

    @Override
    public void execute() {
        
        if(_joystick.getRawAxis(3) > 0)
        {
            ArmShootCommand _command = new ArmShootCommand(_shooter, _joystick.getRawAxis(3) * 0.25);
            _command.execute();
        }
        else if(_joystick.getRawAxis(2) > 0)
        {
            ArmShootCommand _command = new ArmShootCommand(_shooter, -_joystick.getRawAxis(2) * 0.5);
            _command.execute();
        }
        else if(_joystick.getRawButton(6))  
        {
            ArmShootCommand _command = new ArmShootCommand(_shooter, 0.35);
            _command.execute();
        }
        else if(_joystick.getRawButton(3))
        {
            shooterTimer.reset();
            shooterTimer.start();
            while(!shooterTimer.hasElapsed(0.75))
            {
                ArmShootCommand _Command = new ArmShootCommand(_shooter, 1, "B");
                _Command.execute();
            }
            shooterTimer.reset();
            shooterTimer.start();
            while (!shooterTimer.hasElapsed(0.65)) 
            {
                ArmShootCommand _Command = new ArmShootCommand(_shooter, 1);
                _Command.execute();    
            }
            
        }
        else{
            ArmShootCommand _command = new ArmShootCommand(_shooter, 0);
            _command.execute();

        }
    }

}