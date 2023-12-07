package frc.robot;

public final class Constants {
  public final int joystick_PIN =0;

  public static class DriveConstants{
   public final int leftFront_ID = 2;
   public final int leftBack_ID = 3;
   public final int rightFront_ID = 4;
   public final int rightBack_ID = 5;
   
  }
  public static class ArmConstants{
    public final int armSpark_ID = 1;
  }
   public static class GripperContants{
    public final int gripperSpark_ID = 6;
   }
   
  //here we are giving velocity
  public final double drive_SPEED =0.6;
  public final double shoot_SPEED= 0.5;
  public final double intake_SPEED=0.5;
}
