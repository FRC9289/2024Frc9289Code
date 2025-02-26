// package frc.robot.SubsystemCommands;

// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.subsystems.Chassis;

// public class DriveCommand extends Command{

//     Chassis _chassis;
//     double _seconds;
//     double _turn;
//     double _direction;


//     // idk if name needs to get changed
//     public DriveCommand(Chassis chassis, double turnMovement, double linearMovement)
//     {
//         _chassis = chassis;
//         _turn = turnMovement;
//         _direction = linearMovement;
//         addRequirements(chassis);
//     }

//     // Called when the command is initially scheduled.
//     @Override
//     public void initialize() {
//     }

//     // Called every time the scheduler runs while the command is scheduled.
//     @Override
//     public void execute() {
//         _chassis.Drive(_turn, _direction);
//     }

//     // Called once the command ends or is interrupted.
//     @Override
//     public void end(boolean interrupted) {
//         _chassis.Drive(0, 0);
        
//     }

// }
