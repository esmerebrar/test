package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;

public class DriveSub extends SubsystemBase {
  Constants constants = new Constants();
  DriveConstants driveConstants = new DriveConstants();

  CANSparkMax leftFront = new CANSparkMax(driveConstants.leftFront_ID,MotorType.kBrushless);
  CANSparkMax leftBack = new CANSparkMax(driveConstants.leftBack_ID,MotorType.kBrushless);
  MotorControllerGroup lEFT_Group = new MotorControllerGroup(leftFront,leftBack);

  CANSparkMax rightFront = new CANSparkMax(driveConstants.rightFront_ID,MotorType.kBrushless);
  CANSparkMax rightBack = new CANSparkMax(driveConstants.rightBack_ID,MotorType.kBrushless);
  MotorControllerGroup RİGHT_GROUP = new MotorControllerGroup(rightFront,rightBack);

  DifferentialDrive differentialDrive = new DifferentialDrive(lEFT_Group, RİGHT_GROUP);
  Joystick joystick = new Joystick(constants.joystick_PIN);

  public void aracdeDrive(double maxSpeed){
    differentialDrive.arcadeDrive( joystick.getRawAxis(1) * maxSpeed,joystick.getRawAxis(2) *maxSpeed);
   
  }
 

  public DriveSub() {}

  
  public boolean exampleCondition() {
    
    return false;
  }

  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
