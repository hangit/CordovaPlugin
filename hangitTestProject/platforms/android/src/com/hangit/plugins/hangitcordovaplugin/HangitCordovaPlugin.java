//
//  HangitPlugin.m
//  http://www.hangit.com/
//

package com.hangit.plugins.hangitcordovaplugin;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
//import org.apache.cordova.PermissionHelper;
//import android.support.v7.app.AppCompatActivity;

import com.hangit.android.hangit_sdk.ManagerGeneral;

import com.hangit.MainActivityHangitExt;

import static com.hangit.android.hangit_sdk.ManagerGeneral.*;

public class HangitCordovaPlugin extends CordovaPlugin {
    public static final int REQUEST_CODE = 0x0ba7c0de;


    private static  String HANGIT_ID = "";

    private static final String INIT = "init";
    private static final String START = "start";
    private static final String STOP = "stop";
    private static final String DEALS = "deals";
    private static final String CLEAR = "clear";

    private static final String LOG_TAG = "HangitCordovaPlugin";
    private static final String TAG = "Hangit Specific";

    private JSONArray requestArgs;
    private CallbackContext callbackContext;

    /**
     * Constructor.
     */
    public HangitCordovaPlugin() {
    }

    public void initITC(String apiKey) {

        if ( apiKey.equals("") ) {
            if (HANGIT_ID.equals("")) {
                Log.i("CordovaLog", "hangitappid is empty");
                this.callbackContext.error("Unexpected error - hangitappid is empty");
                return;
            } else {
                apiKey = HANGIT_ID;
                Log.i("CordovaLog", "using remembered hangitid");
            }
        }
        ((MainActivityHangitExt)this.cordova.getActivity()).initITC(apiKey);
        this.callbackContext.success();
    }


    /**
     * Executes the request.
     *
     * This method is called from the WebView thread. To do a non-trivial amount of work, use:
     *     cordova.getThreadPool().execute(runnable);
     *
     * To run on the UI thread, use:
     *     cordova.getActivity().runOnUiThread(runnable);
     *
     * @param action          The action to execute.
     * @param args            The exec() arguments.
     * @param callbackContext The callback context used when calling back into JavaScript.
     * @return                Whether the action was valid.
     *
     * @sa https://github.com/apache/cordova-android/blob/master/framework/src/org/apache/cordova/CordovaPlugin.java
     */
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        this.callbackContext = callbackContext;
        this.requestArgs = args;


        if (action.equals(INIT)) {

            init(args);

        } else if (action.equals(START)) {

            //android permission auto add
            if(!hasPermisssion()) {
                requestPermissions(0);
            } else {
                start(args);
            }
        } else if (action.equals(STOP)) {

            //android permission auto add
            if(!hasPermisssion()) {
                requestPermissions(0);
            } else {
                stop(args);
            }
        } else if (action.equals(DEALS)) {

            //android permission auto add
            if(!hasPermisssion()) {
                requestPermissions(0);
            } else {
                deals(args);
            }
        } else if (action.equals(CLEAR)) {

            //android permission auto add
            if(!hasPermisssion()) {
                requestPermissions(0);
            } else {
                clear(args);
            }
        } else {
            return false;
        }
        return true;
    }

    public void init(JSONArray args) {

        if (args.length() > 0) {

            JSONObject obj;
            JSONArray names;
            String key;
            Object value;

            for (int i = 0; i < args.length(); i++) {

                try {
                    obj = args.getJSONObject(i);
                } catch (JSONException e) {
                    Log.i("CordovaLog", e.getLocalizedMessage());
                    continue;
                }

                names = obj.names();
                for (int j = 0; j < names.length(); j++) {
                    try {
                        key = names.getString(j);
                        value = obj.get(key);

                        if ((value instanceof String) && (key.equals("hangitAppId"))) {
                            HANGIT_ID = value.toString();
                            initITC(HANGIT_ID);
                        } else {
                            Log.i("CordovaLog", "hangitappid not provided");
                            this.callbackContext.error("Unexpected error - hangitappid not provided");
                        }

                    } catch (JSONException e) {
                        Log.i("CordovaLog", e.getLocalizedMessage());
                        this.callbackContext.error( e.getLocalizedMessage() );
                    }
                }
            }
        }
    }

    public void start(JSONArray args) {
        initITC("");
    }

    public void stop(JSONArray args) {
        try {
            ManagerGeneral.getHangITClient().stopAllServices(this.cordova.getActivity());
            this.callbackContext.success();

        } catch (Exception e) {
            Log.i("CordovaLog", e.getLocalizedMessage());
            this.callbackContext.error( e.getLocalizedMessage() );
        }
    }

    public void deals(JSONArray args) {
        try {
            ManagerGeneral.openWallet(this.cordova.getActivity());
            this.callbackContext.success();

        } catch (Exception e) {
            Log.i("CordovaLog", e.getLocalizedMessage());
            this.callbackContext.error( e.getLocalizedMessage() );
        }
    }


    public void clear(JSONArray args) {
        try {
            ManagerGeneral.clearDevice(this.cordova.getActivity());
            this.callbackContext.success();
        } catch (Exception e) {
            Log.i("CordovaLog", e.getLocalizedMessage());
            this.callbackContext.error( e.getLocalizedMessage() );
        }
        //ManagerGeneral.getHangITClient().stopAllServices(this.cordova.getActivity());
        //this.callbackContext.success();
    }

/*

    /*

    /**
     * check application's permissions
     */
    /*
    public boolean hasPermisssion() {
        for(String p : permissions)
        {
            if(!PermissionHelper.hasPermission(this, p))
            {
                return false;
            }
        }
        return true;
    }

   public void requestPermissions(int requestCode)
   {
       PermissionHelper.requestPermissions(this, requestCode, permissions);
   }

  public void onRequestPermissionResult(int requestCode, String[] permissions,
                                         int[] grantResults) throws JSONException
   {
       PluginResult result;
       for (int r : grantResults) {
           if (r == PackageManager.PERMISSION_DENIED) {
               Log.d(LOG_TAG, "Permission Denied!");
               result = new PluginResult(PluginResult.Status.ILLEGAL_ACCESS_EXCEPTION);
               this.callbackContext.sendPluginResult(result);
               return;
           }
       }

       switch(requestCode)
       {
           case 0:
               scan(this.requestArgs);
               break;
       }
   }
*/
}