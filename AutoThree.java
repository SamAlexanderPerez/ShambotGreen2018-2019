package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "Depot")


public class AutoThree extends LinearOpMode {

    DcMotor frontLeft, backLeft, frontRight, backRight, hangLift;

    Servo markerServo;

    public void runOpMode() throws InterruptedException{
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");

        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");

        hangLift = hardwareMap.dcMotor.get("hangLift");

        markerServo = hardwareMap.servo.get("markerServo");

        hangLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //this auto will be used when facing the depot and hanging (possibly need to account for moving after landing)
        waitForStart();

        double startTime = getRuntime();

        /*
        need to figure out how to brake the motor for auto. also possibly for teleop if need be.
        Find out which direction the thing goes for positive and negative values. (negative goes down, positive goes up.
        Will need to reverse those if the thing is geared with two gears.)
         */

        while(getRuntime() - startTime >= 0 && getRuntime() - startTime <= 3 && opModeIsActive()){
            //tells the motor to get off of brake and then to go down
            hangLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            hangLift.setPower(0.50);


        }
        while(getRuntime() - startTime >= 3 && getRuntime() - startTime <= 4 && opModeIsActive()){
            //drive the robot backward a tad bit
            hangLift.setPower(0.00);

            frontLeft.setPower(0.22);
            backLeft.setPower(0.22);

            frontRight.setPower(-0.22);
            backRight.setPower(-0.22);
        }
        while(getRuntime() - startTime >= 4 && getRuntime() - startTime <= 10 && opModeIsActive()){
            //will strafe the robot to the right
            frontLeft.setPower(-0.60);
            backLeft.setPower(0.60);
            frontRight.setPower(-0.60);
            backRight.setPower(0.60);

        }
        while(getRuntime() - startTime >= 10 && getRuntime() - startTime <= 12 && opModeIsActive()){
            //tells the motors to stop and then drops the game marker
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);

            markerServo.setPosition(0);

        }
        while (getRuntime() - startTime >= 12 && getRuntime() - startTime <= 14 && opModeIsActive()){
            //strafe the robot to the left
            frontLeft.setPower(0.32);
            backLeft.setPower(-0.32);
            frontRight.setPower(0.32);
            backRight.setPower(-0.32);
        }
        while (getRuntime() - startTime >= 14 && getRuntime() - startTime <= 16 && opModeIsActive()){
            //rotates the robot to the right
            frontLeft.setPower(-0.27);
            backLeft.setPower(-0.27);
            frontRight.setPower(-0.27);
            backRight.setPower(-0.27);
        }

        /*while( getRuntime() - startTime >= 11 && getRuntime() - startTime <= 14 && opModeIsActive()){
            //strafe to the right a little bit
            frontLeft.setPower(-0.20);
            backLeft.setPower(0.20);
            frontRight.setPower(-0.20);
            backRight.setPower(0.20);

        }*/
        while(getRuntime() - startTime >= 16 && getRuntime() - startTime <= 18 && opModeIsActive()){
            //drives the robot backward
            frontLeft.setPower(0.40);
            backLeft.setPower(0.40);

            frontRight.setPower(-0.40);
            backRight.setPower(-0.40);

        }
        while(getRuntime() - startTime >= 18 && getRuntime() - startTime <= 20){
            //strafe the robot to the right
            frontLeft.setPower(-0.38);
            backLeft.setPower(0.38);
            frontRight.setPower(-0.38);
            backRight.setPower(0.38);
        }

        while(getRuntime() - startTime >= 20 && getRuntime() - startTime <= 25 && opModeIsActive()){
            //drives the robot backward
            frontLeft.setPower(0.50);
            backLeft.setPower(0.50);

            frontRight.setPower(-0.50);
            backRight.setPower(-0.50);

        }
     
        frontLeft.setPower(0);
        backLeft.setPower(0);

        frontRight.setPower(0);
        backRight.setPower(0);



    }

}
