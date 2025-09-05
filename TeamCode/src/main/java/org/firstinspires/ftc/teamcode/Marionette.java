package org.firstinspires.ftc.teamcode;

public class Marionette { //Collection of poses
    Pose intakePos = new Pose();
    Pose outtakePos = new Pose();
    Pose specimenIntakePos = new Pose();
    Pose specimenOuttakePos = new Pose();

    Marionette() {
        intakePos.setPose(0.1, 0.2, 0.3, 0.4, 0.5, 600);
        outtakePos.setPose(0.1, 0.2, 0.3, 0.4, 0.5, 600);
        specimenIntakePos.setPose(0.1, 0.2, 0.3, 0.4, 0.5, 600);
        specimenOuttakePos.setPose(0.1, 0.2, 0.3, 0.4, 0.5, 600);
    }
}
