package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import org.rowlandhall.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity Blue1 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 22.76)
                .setColorScheme(new ColorSchemeBlueDark())
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-12, 60, Math.toRadians(0)))

                        .lineToLinearHeading(new Pose2d(60,40,Math.toRadians(70)))
                        .waitSeconds(1)
                        .turn(Math.toRadians(-160))

                        .waitSeconds(0.5)
                        .turn(Math.toRadians(160))

                        .waitSeconds(1)
                        .splineToLinearHeading(new Pose2d(-24,12,Math.toRadians(180)),Math.toRadians(0))


                        .build());
        RoadRunnerBotEntity Blue2 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 22.76)
                .setColorScheme(new ColorSchemeBlueDark())
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(12, 60, Math.toRadians(0)))
                        .lineToLinearHeading(new Pose2d(48,60,Math.toRadians(45)))

                        .waitSeconds(1)

                        .splineToLinearHeading(new Pose2d(36,24,Math.toRadians(0)),Math.toRadians(-45))

                        .waitSeconds(0.5)
                        .splineTo(new Vector2d(48,60),Math.toRadians(45))

                        .waitSeconds(1)
                        .lineToLinearHeading(new Pose2d(24,12,Math.toRadians(0)))

                        .build());

        RoadRunnerBotEntity Red1 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 22.76)
                .setColorScheme(new ColorSchemeRedDark())
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(12, -60, Math.toRadians(180)))

                        .lineToLinearHeading(new Pose2d(-60,-40,Math.toRadians(-130)))
                        .waitSeconds(1)
                        .turn(Math.toRadians(-140))

                        .waitSeconds(0.5)
                        .turn(Math.toRadians(140))

                        .waitSeconds(1)
                        .splineToLinearHeading(new Pose2d(24,-12,Math.toRadians(-180)),Math.toRadians(0))


                        .build());
        RoadRunnerBotEntity Red2 = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 22.76)
                .setColorScheme(new ColorSchemeRedDark())

                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-12, -60, Math.toRadians(180)))
                        .lineToLinearHeading(new Pose2d(-48,-60,Math.toRadians(180+25)))

                        .waitSeconds(1)

                        .splineToLinearHeading(new Pose2d(-36,-24,Math.toRadians(180)),Math.toRadians(180))

                        .waitSeconds(0.5)
                        .splineTo(new Vector2d(-48,-60),Math.toRadians(180+25))

                        .waitSeconds(1)
                        .lineToLinearHeading(new Pose2d(-24,-12,Math.toRadians(180)))

                        .build());
        meepMeep.setBackground(MeepMeep.Background.FIELD_INTOTHEDEEP_JUICE_DARK)
                .setDarkMode(true)

                .setBackgroundAlpha(0.95f)
                .addEntity(Blue1)
                .addEntity(Blue2)
                .addEntity(Red1)
                .addEntity(Red2)


                .start();
    }
}