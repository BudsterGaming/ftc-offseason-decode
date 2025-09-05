package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.nio.channels.Pipe;

@TeleOp
public class EnigmaTeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        PrimaryTeleOP primaryTeleOP = new PrimaryTeleOP();
        primaryTeleOP.selfInitialize();
        PoseSculptor poseSculptor = new PoseSculptor();
        poseSculptor.initHardware();

        waitForStart();

        primaryTeleOP.runLoop();
    }
}
