package org.firstinspires.ftc.teamcode.drive;


import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous
@Config
public class AutonomeBlue2 extends LinearOpMode {
    SampleMecanumDrive mec;


    @Override
    public void runOpMode() throws InterruptedException {
        mec=new SampleMecanumDrive(hardwareMap);


        TrajectorySequence e = mec.trajectorySequenceBuilder(new Pose2d(12, 24*1.8, Math.toRadians(0)))
                .lineToLinearHeading(new Pose2d(48,24*1.8,Math.toRadians(0)))

                .waitSeconds(1)

                .strafeTo(new Vector2d(2.5*24,0))

                .waitSeconds(0.5)
                .splineToLinearHeading(new Pose2d(60,24),Math.toRadians(-40))

                .waitSeconds(1)
                .lineToLinearHeading(new Pose2d(24+24+24,-24,Math.toRadians(0)))

                .build();


        waitForStart();
        mec.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mec.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mec.setPoseEstimate(new Pose2d(12,24*1.8));
        mec.followTrajectorySequence(e);





    }
}
