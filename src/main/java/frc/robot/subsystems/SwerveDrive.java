package frc.robot.subsystems;

public class SwerveDrive {
    public final double L = 20; // equal to length between wheels axles
    public final double W = 20; // equal to width between wheels axles

    //x1 & y1 are the x and y axis from the strafing joystick
    // x2 is the x axis from the rotation joystick
    public void drive(double x1, double y1, double x2){
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
}
