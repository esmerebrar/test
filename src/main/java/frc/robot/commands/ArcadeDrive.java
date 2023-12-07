package frc.robot.commands;
import frc.robot.subsystems.DriveSub;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ArcadeDrive extends CommandBase {
  DriveSub driveSub;
  double maxSpeed;

 
  public ArcadeDrive(DriveSub driveSub, double maxSpeed) {
   this.driveSub=driveSub;
   this. maxSpeed=maxSpeed;
   
    addRequirements(driveSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSub.aracdeDrive(maxSpeed);
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
