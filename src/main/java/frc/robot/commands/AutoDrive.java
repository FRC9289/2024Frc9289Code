package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmShooter;
import frc.robot.subsystems.Chassis;



public class AutoDrive extends Command {

    Chassis _chassis;
    ArmShootCommand _ShootCommand;
    ArmShooter _ArmShooter;
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
        MovementMethods m1 = new MovementMethods(_chassis);
        m1.setSpeed(.5);
        m1.setTime(1);
        m1.move();
        
        ShootMethods s1 = new ShootMethods(_chassis, _ArmShooter);
        s1.setSpeed(1);
        s1.shootHigh();
    //     autonTimer.start();
    //     autonTimer.reset();
    //     autonTimer.restart();

    //     while (!autonTimer.hasElapsed(1.5))
    //     {  
    //         _chassis.Drive(0, .25);
    //     }
    //     _chassis.Drive(0, 0);
    //     autonTimer.restart();
    //     while (!autonTimer.hasElapsed(1.5))
    //     {  
    //         _chassis.Drive(.5, 0);
    //     }
    //     _chassis.Drive(0, 0);
    //     autonTimer.restart();
    //     while (!autonTimer.hasElapsed(2))
    //     {  
    //         _ShootCommand.setSpeed(1.5);
    //         _ShootCommand.setMotorID("B");
    //         _ShootCommand.execute();
    //     }
    //     autonTimer.restart();
    //     while (!autonTimer.hasElapsed(1))
    //     {  
    //         _ShootCommand.setSpeed(1);
    //         _ShootCommand.setMotorID("");
    //         _ShootCommand.execute();
    //     }
    //     _chassis.Drive(0, 0);
    //     _ShootCommand.setSpeed(0);
    //     _ShootCommand.execute();
    //     autonTimer.stop();
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
