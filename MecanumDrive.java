package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Arrays;

@TeleOp(name="TeleOp")
public class MecanumDrive extends OpMode
{
    DcMotor frontLeft, backLeft, frontRight, backRight, manipulatorWheels, manipulatorLift, linearLift, hangLift;

    Servo linearFlip1, linearFlip2, markerServo;




    public void init() {

        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");

        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");

        manipulatorWheels = hardwareMap.dcMotor.get("manipulatorWheels");
        manipulatorLift = hardwareMap.dcMotor.get("manipulatorLift");

        hangLift = hardwareMap.dcMotor.get("hangLift");

        //linearLift = hardwareMap.dcMotor.get("linearLift");

        markerServo = hardwareMap.servo.get("markerServo");
        //linearFlip1 = hardwareMap.servo.get("linearFlip1");
        //linearFlip2 = hardwareMap.servo.get("linearFlip2");





     
    }

    public void loop(){
    telemetry.addData("x",gamepad1.left_stick_x);
    telemetry.addData("y",gamepad1.left_stick_y);
    //below this is drive code. Forward, back, strafe, and rotation

        //whole entire thing allows for our robot to drive much smoother, allows for us to do multiple actions at the same time.

        double FrontLeftVal = gamepad1.left_stick_y - (gamepad1.left_stick_x) + -gamepad1.right_stick_x;
        double FrontRightVal = gamepad1.left_stick_y + (gamepad1.left_stick_x) - -gamepad1.right_stick_x;
        double BackLeftVal  = gamepad1.left_stick_y + (gamepad1.left_stick_x) + -gamepad1.right_stick_x;
        double BackRightVal = gamepad1.left_stick_y - (gamepad1.left_stick_x) - -gamepad1.right_stick_x;

        double[] wheelPowers= {FrontRightVal, FrontLeftVal, BackLeftVal, BackRightVal};
        Arrays.sort(wheelPowers);
        if (wheelPowers[3] > 1){
            FrontLeftVal /= wheelPowers[3];
            FrontRightVal /=wheelPowers[3];
            BackLeftVal /= wheelPowers[3];
            BackRightVal /= wheelPowers[3];
        }

        frontLeft.setPower(FrontLeftVal);
        frontRight.setPower(-FrontRightVal);
        backLeft.setPower(BackLeftVal);
        backRight.setPower(-BackRightVal);









        //drive backward (phone side is forward btw)
        /*if(gamepad1.left_stick_y < 0){
            frontLeft.setPower(gamepad1.left_stick_y);
            backLeft.setPower(gamepad1.left_stick_y);
            frontRight.setPower(-gamepad1.left_stick_y);
            backRight.setPower(-gamepad1.left_stick_y);
            }*/
        //drive forward
        /*else if(gamepad1.left_stick_y > 0){
            frontLeft.setPower(gamepad1.left_stick_y);
            backLeft.setPower(gamepad1.left_stick_y);
            frontRight.setPower(-gamepad1.left_stick_y);
            backRight.setPower(-gamepad1.left_stick_y);
        }*/
        //strafe right
        /*else if(gamepad1.left_stick_x > 0){
            frontLeft.setPower(-gamepad1.left_stick_x);
            backLeft.setPower(gamepad1.left_stick_x);
            frontRight.setPower(-gamepad1.left_stick_x);
            backRight.setPower(gamepad1.left_stick_x);
        }*/
        //strafe left
        /*else if(gamepad1.left_stick_x < 0){
            frontLeft.setPower(-gamepad1.left_stick_x);
            backLeft.setPower(gamepad1.left_stick_x);
            frontRight.setPower(-gamepad1.left_stick_x);
            backRight.setPower(gamepad1.left_stick_x);
        }*/
        //rotate right
        /*else if(gamepad1.right_stick_x > 0){
            frontLeft.setPower(-gamepad1.right_stick_x);
            backLeft.setPower(-gamepad1.right_stick_x);
            frontRight.setPower(-gamepad1.right_stick_x);
            backRight.setPower(-gamepad1.right_stick_x);
        }*/
        //rotate left
        /*else if(gamepad1.right_stick_x < 0){
            frontLeft.setPower(-gamepad1.right_stick_x);
            backLeft.setPower(-gamepad1.right_stick_x);
            frontRight.setPower(-gamepad1.right_stick_x);
            backRight.setPower(-gamepad1.right_stick_x);
        }*/
        /*if (gamepad2.a){
        this turns it the way we want it to btw
            markerServo.setPosition(0);
        }*//*
        else{
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }
*/

        //should move the hanging lift up and down
        hangLift.setPower(-gamepad1.right_stick_y * 0.80);

        if(gamepad1.x){
            //sets the hang motor into brake
            hangLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if(gamepad1.b){
            //takes the hang motor out of lift
            hangLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }






        /*subject to change later, but for now, has second gamepad's left stick control manipulator (compliant wheels) intake
        Don't know which way each goes until testing, but one would go out, other would take them in
         */
        manipulatorWheels.setPower(gamepad2.left_stick_y * 0.25);


        /*Lifting the manipulator. sets a multiplier so it will be a set speed.
        manipulatorLift.setPower(gamepad2.left_stick_x * 0.5);*/

        /*lifting the linear lift to move game pieces up
        linearLift.setPower(gamepad2.right_stick_y * 0.5);*/


        /* code for using the servos. Unsure of which way each one will flip the thing yet, may have to adjust values as well.
        one may have to be reversed depending on how it is mounted. In this case, one will be 0 and the other 1 etc.


        if(gamepad2.y){
            linearFlip1.setPosition(0);
            linearFlip2.setPosition(0);

        }

        if(gamepad2.a){
            linearFlip1.setPosition(1);
            linearFlip2.setPosition(1);
        }
        */


    }

}
