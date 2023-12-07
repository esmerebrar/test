// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ArmSub;

public class ArmUp_Cmd extends InstantCommand {
  private final ArmSub armSub;
 

  public ArmUp_Cmd(ArmSub armSub) {
    this.armSub = new ArmSub();
    addRequirements(armSub);
  }

  
  @Override
  public void initialize() {
    armSub.moveArmToAngle(45.0);
  }

  @Override
  public void execute() {}
  
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
