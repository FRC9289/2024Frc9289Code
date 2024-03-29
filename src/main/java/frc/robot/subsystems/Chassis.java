// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Chassis extends SubsystemBase {
  /** Creates a new Chassis. */

private CANSparkMax _frontLeft = new CANSparkMax(1, MotorType.kBrushed);
private CANSparkMax _backLeft = new CANSparkMax(2, MotorType.kBrushed);
private CANSparkMax _frontRight = new CANSparkMax(3, MotorType.kBrushed);
private CANSparkMax _backRight = new CANSparkMax(4, MotorType.kBrushed);
private static final Chassis _chassis = new Chassis();

private DifferentialDrive _drive = new DifferentialDrive(_frontRight, _frontLeft);


  public Chassis() 
  {
    _backLeft.follow(_frontLeft);
    _backRight.follow(_frontRight);

    // for motor correction
    _frontLeft.setInverted(true);
    _frontRight.setInverted(true);
    _backLeft.setInverted(true);
    _backRight.setInverted(true);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Front Left Speed", _frontLeft.get());
    SmartDashboard.putNumber("Front Right Speed", _frontRight.get());
    SmartDashboard.putNumber("Back Left Speed", _backLeft.get());
    SmartDashboard.putNumber("Back Right Speed", _backRight.get());

    _drive.feed();
  }
  public void teleoPeriodic() {
  
  }

  //turn is for turn robot left/right (little movement)
  //direction positive -> forward, negative -> backward
  public void Drive(double turnMovement, double linearMovement)
  {
    //actual movement
    _drive.arcadeDrive(turnMovement*.85, linearMovement * .85);

    _drive.feed();
    
    

    
  }

  public void TeleOpDrive(Joystick controller)
  {
    // gets input from joysticks
    double axis0 = controller.getRawAxis(0);
    double axis5 = controller.getRawAxis(5);

    // get input (pressed) from B button
    boolean bButton = controller.getRawButton(CommandConstants.ButtonB);

    // defines the turn and linear movement as controller input
    double turnMovement = axis0;
    double linearMovement = -axis5;

    // defines how much the speed is scaled by in slow mode
    double slowScaleSpeed = 0.5;

    // if b button is held down, applies the slow mode scaling
    if (bButton)
    {
      turnMovement *= slowScaleSpeed;
      linearMovement *= slowScaleSpeed;
    }
    
    // log the controller inputs and the values being sent to drive function
    SmartDashboard.putNumber("axis 0", axis0);
    SmartDashboard.putNumber("axis 5", axis5);
    SmartDashboard.putNumber("turn movement", turnMovement);
    SmartDashboard.putNumber("linear movement", linearMovement);

    // drive with specified speed
    Drive(turnMovement, linearMovement);
  }

  public void autoDrive(double turnMovement, double linearMovement)
  {
    //_drive.arcadeDrive(turn, direction);
    _drive.arcadeDrive(turnMovement, linearMovement);
    _drive.feed();
  }
  
  public static Chassis returnInstance()
  {
    return _chassis;
  }

}