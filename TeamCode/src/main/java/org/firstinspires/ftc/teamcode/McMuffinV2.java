package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp
public class McMuffinV2 extends LinearOpMode {
    String[] servoStringsList = {"clawWrist","2","3","4"}; //Add up to 10
    Servo[] servoList = new Servo[servoStringsList.length];
    String[] reversedServos = {"clawWrist","3"};
    int selectedServoIndex = 0;

    double speed = 0.05;
    double[][] pose = new double[2][servoStringsList.length];
    int currentPose = 0;
    boolean tunerActive = true;


    void initializeServoList() {
        for(int i = 0; i < servoStringsList.length; i++) {
            servoList[i] = hardwareMap.get(Servo.class, servoStringsList[i]);
        }
        int index = 0;

        for(int i = 0; i < reversedServos.length; i++) {
            for(int j = 0; j < servoStringsList.length; j++) {
                if (reversedServos[i].equals(servoStringsList[j])) {
                    servoList[j].setDirection(Servo.Direction.REVERSE);
                }
            }
        }
    }



    private void telemetry() {
        if(tunerActive) {
            for(int i = 0; i< servoStringsList.length; i++) {
                telemetry.addData(servoStringsList[i], servoList[i]);
            }
        }
        else {
            /* big o n^2*/for(int i = 0; i < selectedServoIndex; i++) {
                telemetry.addData("pos: ", i);
                for(int j = 0; j < servoStringsList.length; j++) {
                    telemetry.addData(servoStringsList[j] + ": ", pose[i][j]);
                }
            }
        }
        telemetry.update();
    }

    private void savePose() {
        if(gamepad1.start) {
            for(int i = 0; i < servoStringsList.length; i++) {
                pose[currentPose][i] = servoList[i].getPosition();
            }
            currentPose++;
        }
    }

    private void stopTuning() {
        if (gamepad1.back) {
            tunerActive = false;
        }
    }

    //couldn't think of an easier way to do this so just manually edit here (for 2+ servos for 1 action)
    void updateServoPos(double amount) {
        if(selectedServoIndex == 0) {
            servoList[0].setPosition(servoList[0].getPosition() + amount);
        }
        if(selectedServoIndex == 1) {
            servoList[1].setPosition(servoList[1].getPosition() + amount);
        }
        if(selectedServoIndex == 2) {
            servoList[2].setPosition(servoList[2].getPosition() + amount);
        }
        if(selectedServoIndex == 3) {
            servoList[3].setPosition(servoList[3].getPosition() + amount);
        }
        if(selectedServoIndex == 4) {
            servoList[4].setPosition(servoList[4].getPosition() + amount);
        }
        if(selectedServoIndex == 5) {
            servoList[5].setPosition(servoList[5].getPosition() + amount);
        }
        if(selectedServoIndex == 6) {
            servoList[6].setPosition(servoList[6].getPosition() + amount);
        }
        if(selectedServoIndex == 7) {
            servoList[7].setPosition(servoList[7].getPosition() + amount);
        }
    }

    void selectServo() {
        if(gamepad1.a) {
            selectedServoIndex = 0;
        }
        if(gamepad1.x) {
            selectedServoIndex = 1;
        }
        if(gamepad1.y) {
            selectedServoIndex = 2;
        }
        if(gamepad1.b) {
            selectedServoIndex = 3;
        }
        if(gamepad1.dpad_down) {
            selectedServoIndex = 4;
        }
        if(gamepad1.dpad_left) {
            selectedServoIndex = 5;
        }
        if(gamepad1.dpad_up) {
            selectedServoIndex = 6;
        }
        if(gamepad1.dpad_right) {
            selectedServoIndex = 7;
        }
    }

    void moveServo() {
        if (tunerActive) {
            if (gamepad1.right_trigger > 0.4) {
                updateServoPos(speed);
            }
            if (gamepad1.left_trigger > 0.4) {
                updateServoPos(-speed);
            }
        }
    }
    void masterTuner() {
        moveServo();
        savePose();
        stopTuning();
    }



    @Override
    public void runOpMode() throws InterruptedException {

        initializeServoList();

        waitForStart();

        while(opModeIsActive()) {
            masterTuner();
            telemetry();

            sleep(100);
        }
    }
}
