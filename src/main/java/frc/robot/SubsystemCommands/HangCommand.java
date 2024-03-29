package frc.robot.SubsystemCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hanger;

public class HangCommand extends Command{
    
    Hanger hangMotor;
    String motorID ="";
    double power;

   public HangCommand(Hanger _hangMotor, double speed)
   {
        this.hangMotor = _hangMotor;
        this.power = speed;
        addRequirements(hangMotor);
   } 

   @Override
   public void execute()
   {
     hangMotor.move(power);
   }
}
