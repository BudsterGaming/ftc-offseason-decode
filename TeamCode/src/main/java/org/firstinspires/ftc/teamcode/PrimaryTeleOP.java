package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


public class PrimaryTeleOP {
    PoseSculptor sculptor = new PoseSculptor();
    Pose intakePos = new Pose();
    Pose outtakePos = new Pose();
    Pose specimenIntakePos = new Pose();
    Pose specimenOuttakePos = new Pose();

    void selfInitialize() {
        Marionette marionette = new Marionette();

        intakePos = marionette.intakePos;
        outtakePos = marionette.outtakePos;
        specimenIntakePos = marionette.specimenIntakePos;
        specimenOuttakePos = marionette.specimenOuttakePos;
    }

    void setHardwarePoses() {
        sculptor.interpretPose(outtakePos);
    }

    public void runLoop() {
        //yay I love code!!
    }

}
