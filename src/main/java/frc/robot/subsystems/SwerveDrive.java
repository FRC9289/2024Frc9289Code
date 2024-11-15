package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

public class SwerveDrive {
    public static final double L = 20; // equal to length between wheels axles
    public static final double W = 20; // equal to width between wheels axles

    //F -> Front, B -> Back, R -> Right, L -> Left, D -> Drive, T -> Turn
    private CANSparkMax FLDMotor = new CANSparkMax(1, MotorType.kBrushless); // FIELD
    private CANSparkMax FLTMotor = new CANSparkMax(2, MotorType.kBrushless); // FILLET
    private CANSparkMax FRDMotor = new CANSparkMax(3, MotorType.kBrushless); // FORD
    private CANSparkMax FRTMotor = new CANSparkMax(4, MotorType.kBrushless); // FART
    private CANSparkMax BLDMotor = new CANSparkMax(5, MotorType.kBrushless); // BLEED
    private CANSparkMax BLTMotor = new CANSparkMax(6, MotorType.kBrushless); // SANDWHICH
    private CANSparkMax BRDMotor = new CANSparkMax(7, MotorType.kBrushless); // BREAD
    private CANSparkMax BRTMotor = new CANSparkMax(8, MotorType.kBrushless); // brat

    //x1 & y1 are the x and y axis from the strafing joystick
    // x2 is the x axis from the rotation joystick
    public static void drive(double x1, double y1, double x2){
        // square root of the length + width squared
        double r = Math.sqrt ((L * L) + (W * W));
        //revsers the input of the y axis
        y1 *=-1;

        //a, b, c, and d are the speeds of each of the 4 motors,   
        //with this code (0->1), change as needed depending on the motors
        double a = x1 - x2 * (L / r);
        double b = x1 + x2 * (L / r);
        double c = y1 - x2 * (W / r);
        double d = y1 + x2 * (W / r);

        //speeds
        double backRightSpeed = Math.sqrt((a * a) + (d * d));
        double backLeftSpeed = Math.sqrt((a * a) + (c * c));
        double frontRightSpeed = Math.sqrt((b * b) + (d * d));
        double frontLeftSpeed = Math.sqrt((b * b) + (c * c));

        //Angle of each motor
        double backRightAngle = Math.atan2(a, d) / Math.PI;
        double backLeftAngle = Math.atan2(a, c) / Math.PI;
        double frontRightAngle = Math.atan2(b, d) / Math.PI;
        double frontLeftAngle = Math.atan2(b, c) / Math.PI;
    }
    public SwerveDrive(){
        // //reset it every time -> to reset encosder specifically to initial settings
        FLDMotor.restoreFactoryDefaults();
        FLTMotor.restoreFactoryDefaults();
        FRDMotor.restoreFactoryDefaults();
        FRTMotor.restoreFactoryDefaults();
        BLDMotor.restoreFactoryDefaults();
        BLTMotor.restoreFactoryDefaults();
        BRDMotor.restoreFactoryDefaults();
        BRTMotor.restoreFactoryDefaults();

        // //set the speed limit on how fast the motor can go
        hangMotor11.setSmartCurrentLimit(speedlimit);
        hangMotor12.setSmartCurrentLimit(speedlimit);

        // // shooterMotorB.follow(shooterMotorA);

        // //saves changes to motor controller / encoder
        hangMotor11.burnFlash();
        hangMotor12.burnFlash();

    }
}
