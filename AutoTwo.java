package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "Crater")


public class AutoTwo extends LinearOpMode {

    DcMotor frontLeft, backLeft, frontRight, backRight, hangLift;

    Servo markerServo;

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");

        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");

        hangLift = hardwareMap.dcMotor.get("hangLift");

        markerServo = hardwareMap.servo.get("markerServo");

        hangLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


//when facing the crater. This is auto 2
        waitForStart();

        double startTime = getRuntime();

        /*while (getRuntime() - startTime >= 0 && getRuntime() - startTime <= 5 && opModeIsActive()) {
            //Autonomous drive forward (completely ignore this btw)
            frontLeft.setPower(-0.50);
            backLeft.setPower(-0.50);

            frontRight.setPower(0.50);
            backRight.setPower(0.50);

        }*/


        while (getRuntime() - startTime >=0 && getRuntime() - startTime <= 2 && opModeIsActive()){
            //set the hanger out of brake and then have it descend
            hangLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            hangLift.setPower(0.40);

        }

        while(getRuntime() - startTime >= 2 && getRuntime() - startTime <= 4 && opModeIsActive()){
            //will drive the robot forward a bit
            frontLeft.setPower(0.30);
            backLeft.setPower(0.30);

            frontRight.setPower(-0.30);
            backRight.setPower(-0.30);


        }


        while(getRuntime() - startTime >=4 && getRuntime() - startTime <= 6 && opModeIsActive()){
            //strafe the robot to right
            frontLeft.setPower(-0.45);
            backLeft.setPower(0.45);
            frontRight.setPower(-0.45);
            backRight.setPower(0.45);

        }
        while(getRuntime() - startTime >=6 && getRuntime() - startTime <= 8 && opModeIsActive()){
            //drives the robot backwards
            frontLeft.setPower(-0.50);
            backLeft.setPower(-0.50);

            frontRight.setPower(0.50);
            backRight.setPower(0.50);

        }
        while(getRuntime() - startTime >= 8 && getRuntime() - startTime <= 10 && opModeIsActive()){
            //rotate the robot to the left
            frontLeft.setPower(0.20);
            backLeft.setPower(0.20);
            frontRight.setPower(0.20);
            backRight.setPower(0.20);
        }
        while(getRuntime() - startTime >= 10 && getRuntime() - startTime <= 14 && opModeIsActive()){
            //strafe to the right a little
            //if adjustments need to be made, try cutting to 8 secs (cut by 2 secs) and increasing speed to .30
            frontLeft.setPower(-0.20);
            backLeft.setPower(0.20);
            frontRight.setPower(-0.20);
            backRight.setPower(0.20);
        }
        while(getRuntime() - startTime >= 14 && getRuntime() - startTime <= 18 && opModeIsActive()){
            //drive the robot backwards
            frontLeft.setPower(0.50);
            backLeft.setPower(0.50);

            frontRight.setPower(-0.50);
            backRight.setPower(-0.50);
        }
        while(getRuntime() - startTime >= 18 && getRuntime() - startTime <= 20 && opModeIsActive()){
            //tells the motors to stop and drops the team marker
            //try changing this to 15 seconds (down by 1 sec)
            frontLeft.setPower(0);
            backLeft.setPower(0);

            frontRight.setPower(0);
            backRight.setPower(0);

            markerServo.setPosition(0);
        }
        while(getRuntime() - startTime >= 20 && getRuntime() - startTime <= 25 && opModeIsActive()){
            //drive the robot forward into the plane of the crater
            frontLeft.setPower(-0.50);
            backLeft.setPower(-0.50);

            frontRight.setPower(0.50);
            backRight.setPower(0.50);
        }
        /*while(getRuntime() - startTime >= 25 && getRuntime() - startTime <= 27 && opModeIsActive()){
            //turn slightly to the right
            //depending on if need to lower time, possibly get rid of these last two and then increase the speed
            //or the time by a little bit on previous step.

            frontLeft.setPower(-0.2);
            backLeft.setPower(-0.2);
            frontRight.setPower(-0.2);
            backRight.setPower(-0.2);
        }
        while(getRuntime() - startTime >= 27 && getRuntime() - startTime <= 28 && opModeIsActive()){
            //drive slightly forward
            frontLeft.setPower(-0.25);
            backLeft.setPower(-0.25);

            frontRight.setPower(0.25);
            backRight.setPower(0.25);
        }*/


        frontLeft.setPower(0);
        backLeft.setPower(0);

        frontRight.setPower(0);
        backRight.setPower(0);

    }
}
