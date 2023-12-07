// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ArmConstants;

public class ArmSub extends SubsystemBase {

  Constants constants = new Constants();
  ArmConstants armConstants = new ArmConstants();
  
  private final CANSparkMax arm_spark = new CANSparkMax(armConstants.armSpark_ID,MotorType.kBrushless);
  RelativeEncoder encoder ;
    
  double pulsesPerRotation = 1024.0; // bir dönüşte encoderin ürettiği pulse değeri 
  double diaMeter = 0.02; // burda bir çap değeri girmeliyiz çünkü mil redüktöre bağlı, 0.02(2cm) farazi bir değer
  double gearRatio = 15.0; //redüktördeki oran gerekli çünkü mil redüktör sayesinde dönüyor bu oran dönüş hızıyla doğru orantılıdır
  double distancePerPulse = (diaMeter*Math.PI) / gearRatio; //encoderdeki pulse başına uzaklığı ifade ediyor
  double defautArmangle= 45;
  PIDController armPidController = new PIDController(0.3, 0, 0);

  /** Creates a new ArmSub. */
  public ArmSub()  {
      encoder = arm_spark.getEncoder();
      encoder.setPosition(gearRatio/(360/defautArmangle));
      armPidController.setSetpoint(0.0); // istenen değer 
      encoder.setPosition(distancePerPulse); //encoderdeki pulse başına uzaklık ,bu pulse değerinin kaç  oldğu  konum belirlememize yarar
  }

  public void  moveArmToAngle(double angle){ // kolun belirli açıya hereket etmesini sağlar 
    armPidController.setSetpoint(angle);
  }
  
  public void useOutput(double output, double setpoint) {
    arm_spark.set(output);// PID çıkışına hızı ayarla
     }

  public double getMeasurement() {
    return 
    encoder.getPosition()*360/gearRatio; // encoderden açı ölçümünü al
  }
}
