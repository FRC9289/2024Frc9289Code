package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmShooter;
import frc.robot.subsystems.Chassis;

public class MovementMethods {
    private int meters;
    private int turnDegrees;

    public void move(int meters){
        this.meters = meters;
    }
}
