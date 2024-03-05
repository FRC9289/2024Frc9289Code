package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmShooter;
import frc.robot.subsystems.Chassis;

public class MovementMethods {
    private int meters;
    private int turnDegrees;
    private int time;
    Timer timer = new Timer();
    Chassis _chassis;

    public MovementMethods(int meters, int turnDegrees, int time){
        this.meters = meters;
        this.turnDegrees = turnDegrees;
        this.time = time;
    }
    public void move(){
        timer.start();
        int time = this.time;
        int speed = this.meters;
        while (!timer.hasElapsed(time))
        {  
            _chassis.Drive(0, speed);
        }
        _chassis.Drive(0, 0);
        timer.stop();
        timer.reset();

    }
}
