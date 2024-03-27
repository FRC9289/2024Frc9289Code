package frc.robot.SubsystemCommands;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmShooter;

public class ArmShootCommand extends Command
{
    ArmShooter shooter;
    String motorID ="";
    double power;
    
   public ArmShootCommand(ArmShooter _Shooter)
   {
     this.shooter = _Shooter;
     power = 0;
     addRequirements(shooter);
   }

   public ArmShootCommand(ArmShooter _Shooter, double speed)
   {
        this.shooter = _Shooter;
        power = speed;
        addRequirements(_Shooter);
   } 

   public ArmShootCommand(ArmShooter _Shooter, double speed, String motorID)
   {
     this.shooter = _Shooter;
     power = speed;
     this.motorID = motorID;
     addRequirements(_Shooter);
   }

   public void setSpeed(double speed)
   {
     this.power = speed;
   }

   public void setMotorID(String ID)
   {
     this.motorID = ID;
   }

   @Override
   public void execute()
   {
     if(!motorID.equals(""))
          shooter.shootSingle(motorID, power);
     else
        shooter.shoot(power);
   }

   @Override
   public void end(boolean interrupted)
   {
      shooter.stop();
   }
}
