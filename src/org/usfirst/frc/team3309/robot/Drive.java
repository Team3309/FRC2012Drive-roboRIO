package org.usfirst.frc.team3309.robot;

import edu.wpi.first.wpilibj.Victor;

public class Drive {

	//private ModifiedGyro gyro;
	private Victor left_Front;
	private Victor left_Back;
    private Victor right_Front;
    private Victor right_Back;
	private static Drive instance;
	public static Drive getInstance() {	
		if(instance == null) {
			instance = new Drive();
		}
		return instance;
	}
	
	private Drive() {
		left_Front = new Victor(RobotMap.DRIVE_FRONT_LEFT);
		left_Back = new Victor(RobotMap.DRIVE_BACK_LEFT);
		right_Front = new Victor(RobotMap.DRIVE_FRONT_RIGHT);
		right_Back = new Victor(RobotMap.DRIVE_BACK_RIGHT);
		
		//gyro = new ModifiedGyro(RobotMap.DRIVE_GYRO);
	}
	private void driveMecanum(double throttle, double turn, double strafe) {
		System.out.println("throttle: " + throttle);
		System.out.println("turn: " + turn);
		System.out.println("strafe: " + strafe);
		double left_Front_Speed = throttle + turn + strafe;
		double left_Back_Speed = throttle + turn - strafe;
		double right_Front_Speed = throttle - turn - strafe;
		double right_Back_Speed = throttle - turn + strafe;
		setLeftFront(left_Front_Speed);
		setLeftBack(left_Back_Speed);
		setRightFront(right_Front_Speed);
		setRightBack(right_Back_Speed);
	}
	public void setRightBack(double speed) {
		right_Back.set(-speed);
		
	}

	public void setRightFront(double speed) {
		right_Front.set(-speed);
		
	}

	public void setLeftBack(double speed) {
		left_Back.set(speed);
		
	}

	public void setLeftFront(double speed) {
		left_Front.set(speed);
		
	}

	public void drive(double leftX, double leftY, double rightX, double rightY) {
		leftY = -leftY;
		rightY = -rightY;
		driveMecanum(leftY, rightX, leftX);
	}
}
