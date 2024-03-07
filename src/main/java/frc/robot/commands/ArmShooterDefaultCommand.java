package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmShooter;

public class ArmShooterDefaultCommand extends Command {

    ArmShooter _shooter;
    Joystick _joystick;
    Timer shooterTimer = new Timer();
    ShootMethods _method;

    public ArmShooterDefaultCommand(ArmShooter shooter, Joystick _controller) {
        _method = new ShootMethods(shooter);
        _shooter = shooter;
        _joystick = _controller;
        addRequirements(_shooter);
    }

    @Override
    public void execute() {

        // slowly out
        if (_joystick.getRawAxis(CommandConstants.AxisRightTrigger) > 0) {
            _method.shoot(_joystick.getRawAxis(CommandConstants.AxisRightTrigger) * 0.35);
        }
        // intake
        else if (_joystick.getRawAxis(CommandConstants.AxisLeftTrigger) > 0) {
            _method.shoot(-_joystick.getRawAxis(CommandConstants.AxisLeftTrigger) * 0.5);
        } 
        else if (_joystick.getRawButton(CommandConstants.ButtonA)) {
            _method.shootAmp();
        } 
        else if (_joystick.getRawButton(CommandConstants.ButtonX)) {
            _method.shootSpeaker();
        } 
        else {
            _method.stop();
        }
    }

}