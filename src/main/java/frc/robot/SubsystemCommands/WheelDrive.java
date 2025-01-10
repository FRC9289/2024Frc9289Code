package frc.robot.SubsystemCommands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.motorcontrol.Jaguar;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WheelDrive extends SubsystemBase {
    public static final double L = 5;
    public static final double W = 5;

    private Jaguar angleMotor;
    private Jaguar speedMotor;
    private PIDController pidController;
    private final double MAX_VOLTS = 4.95;

    private WheelDrive bR;
    private WheelDrive bL;
    private WheelDrive fR;
    private WheelDrive fL;

    double bRSpeed;
    double bLSpeed;
    double fRSpeed;
    double fLSpeed;
    double bRAngle;
    double bLAngle;
    double fRAngle;
    double fLAngle;

    public void drive(double x1, double y1, double x2) { // x1 = left joystick x, y1 = left joystick y, x2 = right joystick x
        double r = Math.sqrt((L * L) + (W * W));
        y1 *= -1;
    
        double a = x1 - x2 * (L / r);
        double b = x1 + x2 * (L / r);
        double c = y1 - x2 * (W / r);
        double d = y1 + x2 * (W / r);

        this.bRSpeed = Math.sqrt ((a * a) + (d * d));
        this.bLSpeed = Math.sqrt ((a * a) + (c * c));
        this.fRSpeed = Math.sqrt ((b * b) + (d * d));
        this.fLSpeed = Math.sqrt ((b * b) + (c * c));

        this.bRAngle = Math.atan2 (a, d) / Math.PI;
        this.bLAngle = Math.atan2 (a, c) / Math.PI;
        this.fRAngle = Math.atan2 (b, d) / Math.PI;
        this.fLAngle = Math.atan2 (b, c) / Math.PI;
    }

    public WheelDrive (int angleMotor, int speedMotor, int encoder) {
        this.angleMotor = new Jaguar (angleMotor);
        this.speedMotor = new Jaguar (speedMotor);
        pidController = new PIDController(1, 0, 0);

        AnalogInput encoderInput = new AnalogInput(encoder);
        pidController.enableContinuousInput(-1, 1);
    }
    public void drive (double speed, double angle) {
        speedMotor.set (speed);
    
        double setpoint = angle * (MAX_VOLTS * 0.5) + (MAX_VOLTS * 0.5); // Optimization offset can be calculated here.
        if (setpoint < 0) {
            setpoint = MAX_VOLTS + setpoint;
        }
        if (setpoint > MAX_VOLTS) {
            setpoint = setpoint - MAX_VOLTS;
        }
    
        pidController.setSetpoint (setpoint);
    }

    public void SwerveDrive (WheelDrive bR, WheelDrive bL, WheelDrive fR, WheelDrive fL) {
        this.bR = bR;
        this.bL = bL;
        this.fR = fR;
        this.fL = fL;

        bR.drive (this.bRSpeed, this.bRAngle);
        bL.drive (this.bLSpeed, this.bLAngle);
        fR.drive (this.fRSpeed, this.fRAngle);
        fL.drive (this.fLSpeed, this.fLAngle);
    }
}