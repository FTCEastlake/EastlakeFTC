package org.firstinspires.ftc.teamcode;

import static android.os.SystemClock.sleep;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "TutorialLinearOpMode")
//public class Tutorial extends OpMode {
public class TutorialLinearOpMode extends LinearOpMode {

    DcMotor motor;

    int _timeSeconds;
    String _logTag = "Eastlake";

    // Code inside this method will run exactly once after you press the INIT button.
    // This is where you should put all code for the OpMode.
    // https://gm0.org/en/latest/docs/software/getting-started/linear-opmode-vs-opmode.html
    @Override
    public void runOpMode() throws InterruptedException {
        String msg = "Init button was pressed. Waiting for start button to be pressed";
        writeMsgToLog(_logTag, msg); writeMsgToDriverHub(_logTag, msg);
        waitForStart();
        msg = "start button was pressed";
        writeMsgToLog(_logTag, msg); writeMsgToLog(_logTag, msg);

        while (!isStopRequested())
        {
            sleep(1000);
            _timeSeconds++;
            msg = "timer: " + _timeSeconds + " seconds";
            writeMsgToLog(_logTag, msg); writeMsgToLog(_logTag, msg);
        }

        msg = "stop request was detected";
        writeMsgToLog(_logTag, msg); writeMsgToLog(_logTag, msg);
    }

//    @Override
//    public void init() {
//        _timeSeconds = 0;
//        //writeMsgToDriverHub("Initialization: ", "is a success");
//        writeMsgToLog("Initialization: ", "is a success");
//    }
//
//    @Override
//    public void loop() {
//        sleep(1000);
//        _timeSeconds++;
//        //writeMsgToDriverHub("TimerCount: ", _timeSeconds + " seconds");
//        writeMsgToLog("TimerCount: ", _timeSeconds + " seconds");
//    }

    public void writeMsgToLog(String tag, String msg)
    {
        // Send text to the logcat window
        // Note: use [tag: "Eastlake"] to filter on only this code's logs
        Log.d(tag, msg);
    }

    public void writeMsgToDriverHub(String caption, Object value)
    {
        // Send text to the driver hub
        telemetry.addData(caption, value);
        telemetry.update();
    }
}
