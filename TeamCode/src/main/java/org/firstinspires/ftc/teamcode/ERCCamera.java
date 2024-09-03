package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.List;

public class ERCCamera {

    private LinearOpMode _opMode;   // handle to LinearOpMode from the main function
    ERCParameterLogger _logger;

    private VisionPortal _visionPortal;

    // Vision processors
    private AprilTagProcessor _aprilTag;
    private TfodProcessor _tfod;    // TensorFlow Object Detection

    // Always set USE_WEBCAM = true since we are using an external camera. False is for phone camera.
    private static final boolean USE_WEBCAM = true;
    private static final BuiltinCameraDirection INTERNAL_CAM_DIR = BuiltinCameraDirection.BACK;
    private static final int RESOLUTION_WIDTH = 640;
    private static final int RESOLUTION_HEIGHT = 480;


    public ERCCamera(LinearOpMode opMode, ERCParameterLogger logger){
        _opMode = opMode;
        _logger = logger;
    }

    public void init()
    {
        // Processors handles
        _tfod = TfodProcessor.easyCreateWithDefaults();
        _aprilTag = AprilTagProcessor.easyCreateWithDefaults();

        // Vision handle
        _visionPortal = VisionPortal.easyCreateWithDefaults(
                _opMode.hardwareMap.get(WebcamName.class, "Webcam 1"),
                _tfod, _aprilTag);

        float fps = _visionPortal.getFps();
        _logger.writeMsg("Camera module has been initialized. Fps = " + fps);
    }

    /**
     * Add telemetry about AprilTag detections.
     */
//    private void telemetryAprilTag() {
//
//        List<AprilTagDetection> currentDetections = _aprilTag.getDetections();
//        telemetry.addData("# AprilTags Detected", currentDetections.size());
//
//        // Step through the list of detections and display info for each one.
//        for (AprilTagDetection detection : currentDetections) {
//            if (detection.metadata != null) {
//                telemetry.addLine(String.format("\n==== (ID %d) %s", detection.id, detection.metadata.name));
//                telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (inch)", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
//                telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
//                telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));
//            } else {
//                telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
//                telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detection.center.x, detection.center.y));
//            }
//        }   // end for() loop
//
//        // Add "key" information to telemetry
//        telemetry.addLine("\nkey:\nXYZ = X (Right), Y (Forward), Z (Up) dist.");
//        telemetry.addLine("PRY = Pitch, Roll & Yaw (XYZ Rotation)");
//        telemetry.addLine("RBE = Range, Bearing & Elevation");
//
//    }   // end method telemetryAprilTag()
}
