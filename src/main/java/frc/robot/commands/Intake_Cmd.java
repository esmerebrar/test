// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GripperSub;

public class Intake_Cmd extends CommandBase {
  double speed;
  GripperSub gripperSub ;
  
   
  /** Creates a new Intake_Cmd. */
  public Intake_Cmd(GripperSub gripperSub,double speed) {
    this.gripperSub= gripperSub;
    this.speed = speed;
    addRequirements(gripperSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    gripperSub.givePower_gripper(-speed);
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
