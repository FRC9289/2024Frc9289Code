<<<<<<< HEAD:src/main/java/frc/robot/SubsystemCommands/HangCommand.java
package frc.robot.SubsystemCommands;
// package frc.robot.commands;
=======
package frc.robot.commands;
>>>>>>> 4c95147c7389ed9bd57419cd9722326b01bc48d8:src/main/java/frc/robot/commands/HangCommand.java

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Hanger;

public class HangCommand extends Command{
    
    Hanger hangMotor;
    String motorID ="";
    double power;

   public HangCommand(Hanger _hangMotor, double speed)
   {
        this.hangMotor = _hangMotor;
        power = speed;
        addRequirements(_hangMotor);
   } 

   @Override
   public void execute()
   {
        hangMotor.move(power);
   }
}
