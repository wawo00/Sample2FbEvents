package com.upltv.roy.support.sample2fbevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;

public class MainActivity extends AppCompatActivity {
    AppEventsLogger logger;
    String TAG="log_event";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logger = AppEventsLogger.newLogger(this);

    }


    /**
     * CompletedRegistration
     * @param registrationMethod
     */
    public void logCompletedRegistrationEvent (String registrationMethod) {
        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_REGISTRATION_METHOD, registrationMethod);
        logger.logEvent(AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, params);
    }

    /**
     * CompletedTutorial
     * @param contentId
     * @param success
     */
    public void logCompletedTutorialEvent (String contentId, boolean success) {
        Bundle params = new Bundle();
        params.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, contentId);
        params.putInt(AppEventsConstants.EVENT_PARAM_SUCCESS, success ? 10 : 99);
        logger.logEvent(AppEventsConstants.EVENT_NAME_COMPLETED_TUTORIAL, params);
    }

    public void completeRegister(View view) {
        Log.i(TAG,"completeRegister");
        new Mythread().start();
        logCompletedRegistrationEvent("I am registrationMethod");
    }

    public void completeGuide(View view) {
        Log.i(TAG,"completeGuide");
        new Mythread().start();
        logCompletedTutorialEvent("account099999",true);
    }

    class Mythread extends Thread {
        @Override
        public void run() {
            try {
					Thread.sleep(3*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        }
    }
}
