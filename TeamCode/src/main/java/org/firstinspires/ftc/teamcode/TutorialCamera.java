package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

@TeleOp(name = "TutorialCamera")
public class TutorialCamera extends LinearOpMode {

    // Always set USE_WEBCAM = true since we are using an external camera. False is for phone camera.
    private static final boolean USE_WEBCAM = true;
    private TfodProcessor tfod;
    private VisionPortal visionPortal;

    // Instantiate all necessary sub modules
    ERCParameterLogger _logger;
    ERCCamera _camera;


    @Override
    public void runOpMode() throws InterruptedException {

        initModules();

        // Wait for the DS start button to be touched.
        String msg = "To preview camera, click the 3 dots on upper right corner and choose Camer Stream.\n";
        msg += "Touch play to start opMode.";
        _logger.writeMsg(msg);

        waitForStart();
    }

    private void initModules() {
        // Always initialize logger first as it can be passed to the other objects.
        initLogger();
        initCamera();
    }

//region CAMERA

    private void initCamera(){
        _camera = new ERCCamera(this, _logger);
        _camera.init();
    }

//endregion

//region LOGGER

    // I'm just using "param#" as generic parameters here.
    // You should name the parameters according to the value that it's tracking.
    // ex: String _paramController = "Controller";
    String _param1 = "param1";
    String _param2 = "param2";
    String _param3 = "param3";

    private void initLogger(){
        _logger = new ERCParameterLogger(this);
        _logger.init();

        // Add all of the parameters you want to see on the driver hub display.
        _logger.addParameter(_param1, 1);
        _logger.addParameter(_param2, 2);
        _logger.addParameter(_param3, 3);
    }
//endregion

}
