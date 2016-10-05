package com.hangit;
 
 
 import android.os.Bundle;
 import android.util.Log;
 import org.apache.cordova.*;
 
import com.hangit.android.hangit_sdk.HangITClient;
import com.hangit.android.hangit_sdk.HangITBoundingBox;
import com.hangit.android.hangit_sdk.ModelBoundingBoxResponse;
import com.hangit.android.hangit_sdk.ManagerGeneral;
import com.hangit.android.hangit_sdk.ManagerPlaces;
import com.hangit.android.hangit_sdk.UtilGeo;
import com.hangit.android.hangit_sdk.UtilIntent;
import com.hangit.android.hangit_sdk.UtilLogger;
 
 public class MainActivityHangitExt extends CordovaActivity   implements HangITClient.HangITClientEventListener{


     public void initITC(String apiKey) {
         //    ManagerGeneral.getHangITClient().addEventListener(this);
         ManagerGeneral.getHangITClient().initialize(this, apiKey, "");
     }

     public HangITClient  getHangITClient() {
         //    ManagerGeneral.getHangITClient().addEventListener(this);
         return ManagerGeneral.getHangITClient();
     }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Set by <content src="index.html" /> in config.xml
        //initITC("a905ddca3dde20e96094a1711c70e247");
        ManagerGeneral.getHangITClient().addEventListener(this);
        loadUrl(launchUrl);
    }


    @Override
    protected void onPause() {

        //Log.d(TAG,"HangitCordovaPlugin activity onPause()");
        super.onPause();
        ManagerGeneral.getHangITClient().onPause(this);

    }

    @Override
    protected void onResume() {
        //Log.d(TAG, "onResume");
        super.onResume();

    }

    @Override
    public void onBoundingBoxNetworkFailure(String s) {

    }

    @Override
    public void onBoundingBoxChange(ModelBoundingBoxResponse modelBoundingBoxResponse) {

    }

    @Override
    public void onHangITClientFailureEvent(int i, int i1) {
    //    Log.d(TAG, "HangIT Client Failure.  Event type " + i + " - Failure type " + i1);

    }

    @Override
    public void onPlaceEncountered(HangITBoundingBox[] hangITBoundingBoxes) {
        Log.d(TAG, "EncounteredPlace? : " + hangITBoundingBoxes);
    }


}
