package org.firstinspires.ftc.teamcode.marionette;

import com.qualcomm.robotcore.hardware.Servo;


public class PoseSculptor { //will interpret poses and turn them into hardware actions
    Servo outtakeLeft, outtakeRight, claw, clawWrist, wristLeft, slideLeft, slideRight;
    boolean haveInitializedHardware = false;

    public void interpretPose(Pose poseToInterpret) {
        if (!haveInitializedHardware) {
            initHardware();
            haveInitializedHardware = true;
        }
        poseToInterpret.exportPoseValues();

        outtakeLeft.setPosition(poseToInterpret.outtakePosExport);
        outtakeRight.setPosition(poseToInterpret.outtakePosExport);
        claw.setPosition(poseToInterpret.clawPosExport);
        clawWrist.setPosition(poseToInterpret.clawWristPosExport);
        wristLeft.setPosition(poseToInterpret.wristPosExport);
        slideLeft.setPosition(poseToInterpret.slidePosExport);
        slideRight.setPosition(poseToInterpret.slidePosExport);
    }


    void initHardware() {
        //Imagine I just initialize the hw here I just don't know what hw we have :D
    }
}
