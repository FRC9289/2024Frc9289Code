// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.commands.CommandConstants;
import frc.robot.subsystems.Drivetrain;

public class SwerveDrive extends Command {
  private Drivetrain drivetrain = Drivetrain.getInstance();

  /** Creates a new SwerveDrive. */
  public SwerveDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.swerveDrive(
        -RobotContainer.driverController.getRawAxis(CommandConstants.AxisLeftStickY), 
        -RobotContainer.driverController.getRawAxis(CommandConstants.AxisLeftStickX), 
        -RobotContainer.driverController.getRawAxis(CommandConstants.AxisRightStickX),
        !RobotContainer.driverController.getRawButton(XboxController.Button.kB.value),
        new Translation2d(),
        true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stopModules();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}