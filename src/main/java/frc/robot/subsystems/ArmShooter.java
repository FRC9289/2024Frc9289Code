// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class ArmShooter extends SubsystemBase {
  private final int motorACanID = 9;
  private final int motorBCanID = 10;
  private final int motorSpeedLimit = 1000;
  private CANSparkMax shooterMotorA = new CANSparkMax(motorACanID,MotorType.kBrushless );
  private CANSparkMax shooterMotorB = new CANSparkMax(motorBCanID,MotorType.kBrushless );
  /** Creates a new Elevator. */
  public ArmShooter() 
  {
    //reset it every time -> to reset encoder specifically to initial settings
    shooterMotorA.restoreFactoryDefaults();
    shooterMotorB.restoreFactoryDefaults();

    //set the speed limit on how fast the motor can go
    shooterMotorA.setSmartCurrentLimit(motorSpeedLimit);
    shooterMotorB.setSmartCurrentLimit(motorSpeedLimit);

    // shooterMotorB.follow(shooterMotorA);

    //saves changes to motor controller / encoder
    shooterMotorA.burnFlash();
    shooterMotorB.burnFlash();
  }

  //turns motor / makes it work
  public void shoot(double speed)
  {
    //for direction of movement
    shooterMotorA.set(speed);
    shooterMotorB.set(speed);
    
    
  }

  public void stop()
  {
    shooterMotorA.set(0);
    shooterMotorB.set(0);
  }

  public void shootSingle(String motorID, double speed)
  {
    if(motorID.equals("A"))
      shooterMotorA.set(speed);
    else
      shooterMotorB.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("shooter moter A", shooterMotorA.get());
    SmartDashboard.putNumber("Shooter moter B", shooterMotorB.get());
  }
}
