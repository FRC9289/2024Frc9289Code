package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.ArmShooter;
import frc.robot.subsystems.Chassis;

public class ShootMethods {
    private double speed;
    private double time;
    Chassis _chassis;
    ArmShooter _ArmShooter;
    Timer timer = new Timer();

    //object to initialize movement instructions to
    public ShootMethods (double speed, double time, Chassis _Chassis, ArmShooter _ArmShooter) {
        this.speed = speed;
        this.time = time;
        this._chassis = _Chassis;
        this._ArmShooter = _ArmShooter;
    }
    public ShootMethods (Chassis _Chassis) {
        this.speed = 0;
        this.time = 0;
        this._chassis = _Chassis;
        this._ArmShooter = _ArmShooter;
    }

    //set meters method
    public void setSpeed(double speed){
        this.speed = speed;
    }
    //set time method
    public void setTime(double time){
        this.time = time;
    }

    //movement forward method
    public void shootHigh(){
        double time = this.time;
        double speed = this.speed;

        //         autonTimer.start();
        // autonTimer.reset();
        // autonTimer.restart();

        // while (!autonTimer.hasElapsed(1.5))
        // {  
        //     _chassis.Drive(0, .25);
        // }
        // _chassis.Drive(0, 0);
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
