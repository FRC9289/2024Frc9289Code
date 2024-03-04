// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Chassis;


public class ArcadeDrive extends Command {
  /** Creates a new ArcadeDrive. */
  private Chassis _chassis;
  private Joystick _controller;

  public ArcadeDrive(Chassis chassis, Joystick controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    _chassis = chassis;
    _controller = controller;
    addRequirements(_chassis);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    _chassis.TeleOpDrive(_controller);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
