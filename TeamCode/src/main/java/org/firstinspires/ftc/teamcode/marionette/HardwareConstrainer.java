package org.firstinspires.ftc.teamcode.marionette;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

public class HardwareConstrainer {
    public static String exceptionMessage = " is nonexistent/is null.";

    static class varConstraints {
        double min, max;

        varConstraints(double min, double max) {
            this.min = min;
            this.max = max;
        }
    }

    private static final Map<String, varConstraints> constraints = new HashMap<>();
    private static final Map<String, Double> values = new HashMap<>();
    private static boolean isInitialized = false;

    private static void init() {
        if (!isInitialized) {
            isInitialized = true;


            constraints.put("outtake", new varConstraints(0, 0.10));
            constraints.put("claw", new varConstraints(0.4, 0.8));
            constraints.put("clawWrist", new varConstraints(0.4, 0.8));
            constraints.put("wrist", new varConstraints(0.4, 0.8));
            constraints.put("slide", new varConstraints(0.2, 0.9));
            constraints.put("lift", new varConstraints(5, 600));
        }
    }

    public static boolean checkValue(String varToCheck, double valueToSet) {
        init();

        varConstraints toCheck = constraints.get(varToCheck);
        try {
            if (toCheck == null) {
                throw new RuntimeException("varToCheck does not exist/is null!");
            }
        } catch (RuntimeException exception) {
            throw new RuntimeException(varToCheck + exceptionMessage);
        }

        if (valueToSet <= toCheck.max && valueToSet >= toCheck.min) {
            return true;
        }
        else {
            return false;
        }
    }

    public static double getMin(String name) {
        init();
        return Objects.requireNonNull(constraints.get(name)).min;
    }

    public static double getMax(String name) {
        init();
        return Objects.requireNonNull(constraints.get(name)).max;
    }
}
