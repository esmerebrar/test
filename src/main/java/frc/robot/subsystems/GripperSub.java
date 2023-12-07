// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.GripperContants;

public class GripperSub extends SubsystemBase {
  Constants constants = new Constants();
  GripperContants gripperContants = new GripperContants();
  CANSparkMax gripperSpark = new CANSparkMax(gripperContants.gripperSpark_ID, MotorType.kBrushless);
  /** Creates a new GripperSub. */
  public GripperSub() {}

  public void givePower_gripper( double speed){
    gripperSpark.set(speed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
