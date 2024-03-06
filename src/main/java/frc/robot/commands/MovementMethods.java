package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Chassis;

public class MovementMethods {
    private double speed;
    private double turnDegrees;
    private double time;
    Chassis _chassis;
    Timer timer = new Timer();

    //object to initialize movement instructions to
    public MovementMethods (double speed, double degrees, double time, Chassis _Chassis) {
        this.speed = speed;
        this.turnDegrees = degrees;
        this.time = time;
        this._chassis = _Chassis;
    }
    public MovementMethods (Chassis _Chassis) {
        this.speed = 0;
        this.turnDegrees = 0;
        this.time = 0;
        this._chassis = _Chassis;
    }

    //set meters method
    public void setSpeed(double speed){
        this.speed = speed;
    }
    //set degrees method
    public void setDegrees(double degrees){
        this.turnDegrees = degrees;
    }
    //set time method
    public void setTime(double time){
        this.time = time;
    }

    //movement forward method
    public void move(){
        double time = this.time;
        double speed = this.speed;

            //     autonTimer.start();
    //     autonTimer.reset();
    //     autonTimer.restart();

    //     while (!autonTimer.hasElapsed(1.5))
    //     {  
    //         _chassis.Drive(0, .25);
    //     }
    //     _chassis.Drive(0, 0);
        timer.start();
        timer.reset();
        timer.restart();

        while (!timer.hasElapsed(time))
        {  
            _chassis.autoDrive(0, .4);
        }
        _chassis.autoDrive(0, 0);

        timer.stop();
        timer.reset();
    }
    //turn a certain num of degrees method
    public void turn(){
        int time = 0;
        int turnNum = 0;
        timer.start();
        timer.reset();
        timer.restart();

        while (!timer.hasElapsed(time))
        {  
            _chassis.Drive(turnNum, 0);
        }
        _chassis.Drive(0, 0);
        timer.restart();
    }

}
