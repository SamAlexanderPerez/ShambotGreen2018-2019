package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name ="TestAuto")
public class AutoOne extends LinearOpMode {

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

        hangLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);





//when facing the depot. This will be auto 1
        waitForStart();

        double startTime = getRuntime();

        while (getRuntime() - startTime >= 0 && getRuntime() - startTime <= 3 && opModeIsActive()){
            hangLift.setPower(-0.60);
            hangLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }



        /*while (getRuntime() - startTime >= 0 && getRuntime() - startTime <= 4 && opModeIsActive()) {
            //Autonomous drive forward (technically drives our robot backwards)
            frontLeft.setPower(0.50);
            backLeft.setPower(0.50);

            frontRight.setPower(-0.50);
            backRight.setPower(-0.50);


        }

        while (getRuntime() - startTime >= 4 && getRuntime() - startTime <= 7 && opModeIsActive()) {
            frontLeft.setPower(0);
            backLeft.setPower(0);

            frontRight.setPower(0);
            backRight.setPower(0);

            //markerServo.setPosition(1);


            markerServo.setPosition(0);
        }

        //turns our robot to the right
        while (getRuntime() - startTime >= 7 && getRuntime() - startTime <= 11 && opModeIsActive()){
            frontLeft.setPower(-0.30);
            backLeft.setPower(-0.30);

            frontRight.setPower(-0.30);
            backRight.setPower(-0.30);
        }

        //drives the robot forward again
        while (getRuntime() - startTime >= 11 && getRuntime() - startTime <= 17 && opModeIsActive()){
            frontLeft.setPower(0.50);
            backLeft.setPower(0.50);

            frontRight.setPower(-0.50);
            backRight.setPower(-0.50);

        }*/
/*
        frontLeft.setPower(0);
        backLeft.setPower(0);

        frontRight.setPower(0);
        backRight.setPower(0);
        */
    }
}

/* make sure to confirm things with Joe btw. ask if have to create a second auto file for it.
auto 2 will focus on just straight driving
essentially just copy and paste the code that drives forward
 */
