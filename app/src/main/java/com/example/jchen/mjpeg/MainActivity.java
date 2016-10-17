package com.example.jchen.mjpeg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int MENU_QUIT = 1;
    private boolean suspending = false;

    private TextView droneNameTextView;

    private RelativeLayout mLayout;
    private LinearLayout mContainerLayout;

    private LinearLayout mRing1;
    private LinearLayout mRing2;
    private LinearLayout mRing3;
    private LinearLayout mRing4;
    private LinearLayout mRing5;

    private LinearLayout mPoint_1;
    private LinearLayout mPoint_2;
    private LinearLayout mPoint_3;
    private LinearLayout mPoint_4;
    private LinearLayout mPoint_5;

    private Button mSelfieButton;
    private Button mPilotButton;


    private static final String TAG = "MainActivity";
    private static final String URL = "http://trackfield.webcam.oregonstate.edu/axis-cgi/mjpg/video.cgi?resolution=800x600&amp%3bdummy=1333689998337";
    private static final boolean DEBUG = true;
    //private MjpegView mv;

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    /* Creates the menu items */
    //public boolean onCreateOptionsMenu(Menu menu) {
    //    menu.add(0, MENU_QUIT, 0, "Quit");
    //    return true;
    //}

    /* Handles item selections */
    //public boolean onOptionsItemSelected(MenuItem item) {
    //    switch (item.getItemId()) {
    //        case MENU_QUIT:
    //            finish();
    //            return true;
    //    }
    //    return false;
    //}

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //String URL = "http://gamic.dnsalias.net:7001/img/video.mjpeg";
        //String URL = "http://88.53.197.250/axis-cgi/mjpg/video.cgi?resolution=320x240";

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        //mv = new MjpegView(this);

        //setContentView(mv);
        //Log.i("Main", "Alive");
        //mv.setSource(MjpegInputStream.read(URL));
        //mv.setDisplayMode(MjpegView.SIZE_BEST_FIT);
        //mv.showFps(false);

        //String URL = "http://trackfield.webcam.oregonstate.edu/axis-cgi/mjpg/video.cgi?resolution=800x600&amp%3bdummy=1333689998337";

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //mv = new MjpegView(this);
        //setContentView(mv);
        //new DoRead().execute(URL);
        //setContentView(mv);
        //setTitle(R.string.title_connecting);
        //new DoRead().execute(URL);

    }

    public void CameraView(View view) {
        Intent intent = new Intent(this, Activity_display_message.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    protected void onResume() {

        Log.d(TAG, "onResume()");
        super.onResume();  // Always call the superclass method first
        //mv = new MjpegView(this);
        //setContentView(mv);
        //new DoRead().execute(URL);
        /*if (mv != null) {
            //if (suspending) {
                new DoRead().execute(URL);
                suspending = false;
            //}
        }*/

    }

    /*public class DoRead extends AsyncTask<String, Void, MjpegInputStream> {

        protected MjpegInputStream doInBackground(String... url) {
            //TODO: if camera has authentication deal with it and don't just not work
            HttpResponse res = null;
            DefaultHttpClient httpclient = new DefaultHttpClient();
            Log.d(TAG, "1. Sending http request");
            try {
                res = httpclient.execute(new HttpGet(URI.create(url[0])));
                Log.d(TAG, "2. Request finished, status = " + res.getStatusLine().getStatusCode());
                if (res.getStatusLine().getStatusCode() == 401) {
                    //You must turn off camera User Access Control before this will work
                    return null;
                }
                return new MjpegInputStream(res.getEntity().getContent());
            } catch (ClientProtocolException e) {
                e.printStackTrace();
                Log.d(TAG, "Request failed-ClientProtocolException", e);
                //Error connecting to camera
            } catch (IOException e) {
                e.printStackTrace();
                Log.d(TAG, "Request failed-IOException", e);
                //Error connecting to camera
            }
            return null;
        }

        @Override
        protected void onPostExecute(MjpegInputStream result) {
            //mv.setSource(result);
            //mv.setDisplayMode(MjpegView.SIZE_BEST_FIT);
            //mv.showFps(true);
            mv.setSource(result);
            if (result != null) {
                result.setSkip(1);
                setTitle(R.string.app_name);
            } else {
                setTitle(R.string.title_disconnected);
            }
            mv.setDisplayMode(MjpegView.SIZE_BEST_FIT);
            mv.showFps(false);
        }

    }*/

    /*public void onResume() {
        if (DEBUG) Log.d(TAG, "onResume()");
        super.onResume();
        if (mv != null) {
            if (suspending) {
                new DoRead().execute(URL);
                suspending = false;
            }
        }
    }*/

    public void onStart() {
        if (DEBUG) Log.d(TAG, "onStart()");
        super.onStart();
    }

    public void onPause() {
        if (DEBUG) Log.d(TAG, "onPause()");
        super.onPause();
        /*if (mv != null) {
            if (mv.isStreaming()) {
                mv.stopPlayback();
                suspending = true;
            }
        }*/
    }

    public void onStop() {
        if (DEBUG) Log.d(TAG, "onStop()");
        super.onStop();
    }

    public void onDestroy() {
        if (DEBUG) Log.d(TAG, "onDestroy()");

        /*if (mv != null) {
            //mv.freeCameraMemory();
        }*/
        super.onDestroy();
    }

}

//public class MainActivity extends AppCompatActivity {
//
//    private static final String TAG = "MjpegActivity";
//
//    private MjpegView mv;
//
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        //sample public cam
//        String URL = "http://trackfield.webcam.oregonstate.edu/axis-cgi/mjpg/video.cgi?resolution=800x600&amp%3bdummy=1333689998337";
//
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        mv = new MjpegView(this);
//        setContentView(mv);
//
//        new DoRead().execute(URL);
//    }
//
//    public void onPause() {
//        super.onPause();
//        mv.stopPlayback();
//    }
//
//    public class DoRead extends AsyncTask<String, Void, MjpegInputStream> {
//
//        protected MjpegInputStream doInBackground(String... url) {
//            //TODO: if camera has authentication deal with it and don't just not work
//            HttpResponse res = null;
//            DefaultHttpClient httpclient = new DefaultHttpClient();
//            Log.d(TAG, "1. Sending http request");
//            try {
//                res = httpclient.execute(new HttpGet(URI.create(url[0])));
//                Log.d(TAG, "2. Request finished, status = " + res.getStatusLine().getStatusCode());
//                if(res.getStatusLine().getStatusCode()==401){
//                    //You must turn off camera User Access Control before this will work
//                    return null;
//                }
//                return new MjpegInputStream(res.getEntity().getContent());
//            } catch (ClientProtocolException e) {
//                e.printStackTrace();
//                Log.d(TAG, "Request failed-ClientProtocolException", e);
//                //Error connecting to camera
//            } catch (IOException e) {
//                e.printStackTrace();
//                Log.d(TAG, "Request failed-IOException", e);
//                //Error connecting to camera
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(MjpegInputStream result) {
//            mv.setSource(result);
//            mv.setDisplayMode(MjpegView.SIZE_BEST_FIT);
//            mv.showFps(true);
//        }
//    }
//}
