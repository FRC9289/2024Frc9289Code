// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.*;
import frc.robot.AutonCommands.AutoDrive;
import frc.robot.AutonCommands.LeftStartAuto;
import frc.robot.AutonCommands.MiddleStartAuto;
import frc.robot.AutonCommands.RightStartAuto;
import frc.robot.commands.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private static final Chassis _chassis = Chassis.returnInstance();
  private final Joystick _chassisController = new Joystick(0);
  private final Joystick _armController = new Joystick(1);
  private final ArmShooter _shooter = new ArmShooter();

  //initializating commands to put up as choices
  private final Command leftCommand = new LeftStartAuto(_chassis, _shooter);
  private final Command middleCommand = new MiddleStartAuto(_chassis, _shooter);
  private final Command rightCommand = new RightStartAuto(_chassis, _shooter);

  
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  

  // private final Hanger _hanger = new Hanger();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    _chassis.setDefaultCommand(new ArcadeDrive(_chassis, _chassisController));
    configureBindings();
    CameraServer.startAutomaticCapture();

    

    //set up choices for autonomous program
    m_chooser.setDefaultOption("Left Start", leftCommand);
    m_chooser.addOption("Middle Start", middleCommand);
    m_chooser.addOption("Right Start", rightCommand);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() 
  {
    _shooter.setDefaultCommand(new ArmShooterDefaultCommand(_shooter, _armController));

    //uncooment when hanger installed onto the bot
    // _hanger.setDefaultCommand(new HangDefaultCommand(_hanger, _armController));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    // return _chassis.Drive(0, 0);
      return m_chooser.getSelected();
  //  return new RunCommand(()-> _chassis.autoDrive());
  }
}