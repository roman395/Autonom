package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Lift{
    public DcMotor motorL;
    public DcMotor motorR;

    public int maxRot=1000;
    public int minRot=-1000;

    LinearOpMode linearOpMode;
    HardwareMap hardwareMap;
    Gamepad g2;

    public Lift(LinearOpMode linearOpMode){
        this.linearOpMode=linearOpMode;
        hardwareMap=linearOpMode.hardwareMap;

        motorL=hardwareMap.get(DcMotor.class,"leftLift");
        motorR=hardwareMap.get(DcMotor.class,"rightLift");

        motorR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorL.setDirection(DcMotorSimple.Direction.REVERSE);

        motorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        g2=linearOpMode.gamepad2;
    }
    public void Control() {
        if (g2.dpad_up&&(motorL.getTargetPosition() < maxRot && motorL.getCurrentPosition() < maxRot)) {
            motorL.setPower(1);
            motorR.setPower(1);
        }
        else if (g2.dpad_down&&(motorL.getTargetPosition() > minRot && motorL.getCurrentPosition() > minRot)) {
            motorR.setPower(-1);
            motorL.setPower(-1);
        }
        else {
            motorL.setPower(0);
            motorR.setPower(0);
        }
    }

}
