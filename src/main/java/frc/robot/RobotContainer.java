package frc.robot;
import frc.robot.commands.Autos;
import frc.robot.commands.Intake_Cmd;
import frc.robot.commands.Shoot;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArmDown_Cmd;
import frc.robot.commands.ArmUp_Cmd;
import frc.robot.subsystems.ArmSub;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.GripperSub;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.simulation.JoystickSim;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  Constants constants = new Constants();
    DriveSub driveSub;
    ArmSub armSub;
    Joystick joystick = new Joystick(constants.joystick_PIN);
    GripperSub gripperSub =new GripperSub();
 
  public RobotContainer() {
    driveSub =  new DriveSub();
      driveSub.setDefaultCommand(new ArcadeDrive(driveSub, constants.drive_SPEED));
      configureBindings();  
   
  }

  private void configureBindings() {
    JoystickButton buttonArmUPButton = new JoystickButton(joystick,1);
    JoystickButton buttonArmDown = new JoystickButton(joystick,2);
  
    new JoystickButton(joystick, 3).whileTrue(new Shoot(gripperSub,constants.shoot_SPEED));
    new JoystickButton(joystick, 3).whileFalse(new Shoot(gripperSub,0));

    new JoystickButton(joystick, 4).whileTrue(new Intake_Cmd(gripperSub,constants.intake_SPEED));
    new JoystickButton(joystick, 4).whileFalse(new Intake_Cmd(gripperSub,0));
  }

}
