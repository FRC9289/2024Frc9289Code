// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class CommandConstants {
    // Gamepad Axises
    public static final int AxisLeftStickX = 0;
    public static final int AxisLeftStickY = 1;
    public static final int AxisLeftTrigger = 2;
    public static final int AxisRightTrigger = 3;
    public static final int AxisRightStickX = 4;
    public static final int AxisRightStickY = 5;

    // Gamepad POVs
    public static final int PovUp = 0;
    public static final int PovRight = 90;
    public static final int PovDown = 180;
    public static final int PovLeft = 270;

    // Gamepad buttons
    public static final int ButtonA = 1; // Bottom Button
    public static final int ButtonB = 2; // Right Button
    public static final int ButtonX = 3; // Left Button
    public static final int ButtonY = 4; // Top Button
    public static final int ButtonShoulderL = 5;
    public static final int ButtonShoulderR = 6;
    public static final int ButtonBack = 7;
    public static final int ButtonStart = 8;
    public static final int ButtonLeftStick = 9;
    public static final int ButtonRightStick = 10;
}
