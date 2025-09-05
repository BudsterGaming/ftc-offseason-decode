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
        try {
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
            //A pid can be added here if you are using one
        } catch (RuntimeException exception) {
            if (exception.getMessage().contains(HardwareConstrainer.exceptionMessage)) {
                throw exception;
            }
            else {
                if (exception.getMessage().contains("Outtake")) {
                    clampToNearestExtreme(outtakePosToSet, "outtake");
                }
                if (exception.getMessage().contains("Claw") && !exception.getMessage().contains("Wrist")) {
                    clampToNearestExtreme(clawPosToSet, "claw");
                }
                if (exception.getMessage().contains("Claw Wrist")) {
                    clampToNearestExtreme(clawWristPosToSet, "clawWrist");
                }
                if (exception.getMessage().contains("Wrist") && !exception.getMessage().contains("Claw")) {
                    clampToNearestExtreme(wristPosToSet, "wrist");
                }
                if (exception.getMessage().contains("Slide")) {
                    clampToNearestExtreme(slidePosToSet, "slide");
                }
            }
        }
    }

    void clampToNearestExtreme(double toClamp, String varName) {
        if (toClamp < HardwareConstrainer.getMin(varName)) {
            toClamp = HardwareConstrainer.getMin(varName);
        }
        if (toClamp < HardwareConstrainer.getMax(varName)) {
            toClamp = HardwareConstrainer.getMax(varName);
        }
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
