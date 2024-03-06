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
    public static final int GamepadAxisLeftStickX = 1;
    public static final int GamepadAxisLeftStickY = 2;
    public static final int GamepadAxisShoulder = 3;
    public static final int GamepadAxisRightStickX = 4;
    public static final int GamepadAxisRightStickY = 5;
    public static final int GamepadAxisDpad = 6;

    // Gamepad POVs
    public static final int PovUp = 0;
    public static final int PovRight = 90;
    public static final int PovDown = 180;
    public static final int PovLeft = 270;

    // Gamepad buttons
    public static final int GamepadButtonA = 1; // Bottom Button
    public static final int GamepadButtonB = 2; // Right Button
    public static final int GamepadButtonX = 3; // Left Button
    public static final int GamepadButtonY = 4; // Top Button
    public static final int GamepadButtonShoulderL = 5;
    public static final int GamepadButtonShoulderR = 6;
    public static final int GamepadButtonBack = 7;
    public static final int GamepadButtonStart = 8;
    public static final int GamepadButtonLeftStick = 9;
    public static final int GamepadButtonRightStick = 10;
}
