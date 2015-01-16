package com.gustavo.example.tvshows;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by gustavo on 18/11/14.
 */
public class ShowsApplication extends Application {

    private static ShowsApplication instance;
    private RequestQueue mRequestQueue;
    private static final String TAG = ShowsApplication.class
            .getSimpleName();
    private Activity currentActivity;


    public void setCurrentActivity(Activity activity) {
        this.currentActivity = activity;
    }

    public Activity getCurrentActivity() {
        return currentActivity;
    }

    public static ShowsApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

}
