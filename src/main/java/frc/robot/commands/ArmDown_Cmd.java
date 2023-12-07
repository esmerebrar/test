// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ArmSub;

public class ArmDown_Cmd extends InstantCommand {
  private final ArmSub armSub;

  public ArmDown_Cmd(ArmSub armSub) {
    this.armSub = armSub;
    addRequirements(armSub);
  }


  @Override
  public void initialize() {
    armSub.moveArmToAngle(0);
  }


  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
