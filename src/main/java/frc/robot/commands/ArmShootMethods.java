package frc.robot.commands;

import com.fasterxml.jackson.databind.node.ArrayNode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.SubsystemCommands.ArmShootCommand;
import frc.robot.subsystems.ArmShooter;

public class ArmShootMethods {
    ArmShooter _ArmShooter;
    Timer timer = new Timer();

    public ArmShootMethods (ArmShooter _ArmShooter) {
        this._ArmShooter = _ArmShooter;
    }

    //overloads of different types of shoot
    public void shoot(double speed){
        ArmShootCommand _Command = new ArmShootCommand(_ArmShooter, speed);
        _Command.execute();
    }

    public void shoot(double speed, double time){
        timer.reset();
        timer.start();

        while (!timer.hasElapsed(time)) {
            ArmShootCommand _Command = new ArmShootCommand(_ArmShooter, speed);
            _Command.execute();
        }
    }
    
    public void shoot(double speed, String motorID){
        ArmShootCommand _Command = new ArmShootCommand(_ArmShooter, speed, motorID);
        _Command.execute();

    }

    public void shoot(double speed, double time, String motorID){
        timer.reset();
        timer.start();

        while (!timer.hasElapsed(time)) {
            ArmShootCommand _Command = new ArmShootCommand(_ArmShooter, speed, motorID);
            _Command.execute();
        }
    }

    public void stop()
    {
        shoot(0);
    }

    //shoot to the speaker
    public void shootSpeaker(){
        double time;
        double speed = 1;

        timer.reset();
        timer.start();
        time = 1;
        while(!timer.hasElapsed(time))
        {
            ArmShootCommand _Command = new ArmShootCommand(_ArmShooter, speed, "B");
            _Command.execute();
        }
        timer.reset();
        timer.start();
        time = .5;
        speed = 1;
        while (!timer.hasElapsed(time)) 
        {
            ArmShootCommand _Command = new ArmShootCommand(_ArmShooter, speed);
            _Command.execute(); 
        }  
          
    }

    //shoot to the amp
    public void shootAmp(){
        double time;
        double speed = 0.2;

        timer.reset();
        timer.start();

        time = 0.75;
        while (!timer.hasElapsed(time)) {
            ArmShootCommand _Command = new ArmShootCommand(_ArmShooter, speed);
            _Command.execute();
        }
    }
}
