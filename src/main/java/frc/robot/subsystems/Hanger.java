package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hanger extends SubsystemBase{
    
    private final int moterCanID11 = 11;
    private final int moterCanID12 = 12;

    private final int speedlimit = 20;

    private CANSparkMax hangMotor11 = new CANSparkMax(moterCanID11, MotorType.kBrushed);
    private CANSparkMax hangMotor12 = new CANSparkMax(moterCanID12, MotorType.kBrushed);

    public Hanger()
    {
        // //reset it every time -> to reset encosder specifically to initial settings
        hangMotor11.restoreFactoryDefaults();
        hangMotor12.restoreFactoryDefaults();

        // //set the speed limit on how fast the motor can go
        hangMotor11.setSmartCurrentLimit(speedlimit);
        hangMotor12.setSmartCurrentLimit(speedlimit);

        // // shooterMotorB.follow(shooterMotorA);

        // //saves changes to motor controller / encoder
        hangMotor11.burnFlash();
        hangMotor12.burnFlash();
        
    }

    //turns motor / makes it work
    public void move(double speed)
    {
    //for direction of movement
        hangMotor11.set(speed);
        hangMotor12.set(speed);
        
        SmartDashboard.putNumber("Motor 12 power", hangMotor12.get());
        SmartDashboard.putNumber("Motor 11 power", hangMotor12.get());
    }

    public void stop()
    {
        hangMotor11.set(0);
        hangMotor12.set(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("hang motor 11", hangMotor11.get());
        SmartDashboard.putNumber("hang motor 12", hangMotor12.get());
    }
}
