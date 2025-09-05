package org.firstinspires.ftc.teamcode.marionette;

public class Pose { //Pose, also does any crazy checks
    private double outtakePos = 0;
    private double clawPos = 0;
    private double clawWristPos = 0;
    private double wristPos = 0;
    private double slidePos = 0;
    private int liftPos = 0;

    public double outtakePosExport = 0;
    public double clawPosExport = 0;
    public double clawWristPosExport = 0;
    public double wristPosExport = 0;
    public double slidePosExport = 0;
    public int liftPosExport = 0;

    double var1, var2, pid;

    void checkConstraints(double outtakePosToSet, double clawPosToSet, double clawWristPosToSet, double wristPosToSet, double slidePosToSet, int liftPosToSet) {
        if (!HardwareConstrainer.checkValue("outtake", outtakePosToSet)) {
            throw new RuntimeException("Outtake is exceeding constraints!");
        }
        if (!HardwareConstrainer.checkValue("claw", outtakePosToSet)) {
            throw new RuntimeException("Claw is exceeding constraints!");
        }
        if (!HardwareConstrainer.checkValue("clawWrist", outtakePosToSet)) {
            throw new RuntimeException("Claw Wrist is exceeding constraints!");
        }
        if (!HardwareConstrainer.checkValue("wrist", outtakePosToSet)) {
            throw new RuntimeException("Wrist is exceeding constraints!");
        }
        if (!HardwareConstrainer.checkValue("slide", outtakePosToSet)) {
            throw new RuntimeException("Slide is exceeding constraints!");
        }
        //TODO other pid
    }


    public void setPose(double outtakePosToSet, double clawPosToSet, double clawWristPosToSet, double wristPosToSet, double slidePosToSet, int liftPosToSet) {
        checkConstraints(outtakePosToSet, clawPosToSet, clawWristPosToSet, wristPosToSet, slidePosToSet, liftPosToSet);

        outtakePos = outtakePosToSet;
        clawPos = clawPosToSet;
        clawWristPos = clawWristPosToSet;
        wristPos = wristPosToSet;
        slidePos = slidePosToSet;
        liftPos = liftPosToSet;
    }
    public void exportPoseValues() {
        outtakePosExport = outtakePos;
        clawPosExport = clawPos;
        clawWristPosExport = clawWristPos;
        wristPosExport = wristPos;
        slidePosExport = slidePos;
        liftPosExport = liftPos;
    }
    public void toTelemetry() {

    }


}
