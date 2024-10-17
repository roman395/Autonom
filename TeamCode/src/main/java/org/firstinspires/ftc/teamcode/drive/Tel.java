package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.AnalogSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorDigitalTouch;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp
public class Tel extends LinearOpMode {
    DigitalChannel s;
    int dist;
    @Override
    public void runOpMode() throws InterruptedException {
        s=hardwareMap.get(DigitalChannel.class,"A");


        waitForStart();

        while(opModeIsActive()){
            telemetry.addData("getState",!s.getState());
telemetry.addData("0",s.getMode());
            telemetry.update();

        }

    }
}
