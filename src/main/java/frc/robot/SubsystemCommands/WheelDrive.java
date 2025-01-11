package frc.robot.SubsystemCommands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WheelDrive extends SubsystemBase {
    public static final double L = 5;
    public static final double W = 5;
    public void drive(double x1, double y1, double x2) { // x1 = left joystick x, y1 = left joystick y, x2 = right joystick x
        double r = Math.sqrt((L * L) + (W * W));
        y1 *= -1;
    
        double a = x1 - x2 * (L / r);
        double b = x1 + x2 * (L / r);
        double c = y1 - x2 * (W / r);
        double d = y1 + x2 * (W / r);

        double bRSpeed = Math.sqrt ((a * a) + (d * d));
        double bLSpeed = Math.sqrt ((a * a) + (c * c));
        double fRSpeed = Math.sqrt ((b * b) + (d * d));
        double fLSpeed = Math.sqrt ((b * b) + (c * c));
    }
}