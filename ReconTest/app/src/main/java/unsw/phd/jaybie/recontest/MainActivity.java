package unsw.phd.jaybie.recontest;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
//import com.reconinstruments.ui.carousel.CarouselActivity;
//import com.reconinstruments.ui.carousel.CarouselItem;
//import com.reconinstruments.ui.carousel.StandardCarouselItem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {

    private static final String TAG = "CameraActivity";
    static final String CAMERA_APP= "com.reconinstruments.camera";

    Camera camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        TextView landing_text = (TextView) findViewById(R.id.landingView);
        landing_text.setText("in case we need to change the text");
*/

/*
        @Override
        public void onClick(Context context) {
            camera.takePicture(null, null, jpegSavedCallback);
        }
*/
        openCamera();
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_DPAD_CENTER) {
            camera.takePicture(null, null, jpegSavedCallback);
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        openCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeCamera();
    }

    PictureCallback jpegSavedCallback = new PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
            ImageStorageUtils.insertJpeg(MainActivity.this,data,System.currentTimeMillis());
            //preview.setCamera(camera);
        }
    };

    public void openCamera() {
        try {
            camera = Camera.open();
        } catch(RuntimeException ex) {
            Toast.makeText(this, "Failed to open camera", Toast.LENGTH_SHORT).show();
        }
        if(camera!=null) { return; }
            //preview.setCamera(camera);
    }

    public void closeCamera() {
        if(camera != null) {
            //camera.stopPreview();
            camera.release();
            camera = null;
        }
    }

}
