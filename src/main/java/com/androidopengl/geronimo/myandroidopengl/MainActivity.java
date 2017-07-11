package com.androidopengl.geronimo.myandroidopengl;
//Baseado em https://github.com/learnopengles/airhockey/tree/article-1-clearing-the-screen/src/android/src/com/learnopengles/airhockey
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    private GLSurfaceView glSurfaceView;
    private boolean rendererSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setEGLContextClientVersion(2);
        glSurfaceView.setRenderer(new RendererWrapper());
        rendererSet = true;
        setContentView(glSurfaceView);
    }
    protected  void onResume()
    {
        super.onResume();
        if(rendererSet){
            glSurfaceView.onResume();
        }
    }
    protected  void onPause()
    {
        super.onPause();
        if(rendererSet){
            glSurfaceView.onPause();
        }
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
