package com.gustavo.example.tvshows.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gustavo on 18/11/14.
 */
public class ShowsJsonArrayRequest extends com.android.volley.toolbox.JsonArrayRequest {

    private static final int MY_SOCKET_TIMEOUT_MS = 10000;

    public ShowsJsonArrayRequest(String url, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
        setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }


    @Override
    public Map getHeaders() throws AuthFailureError {
        Map headers = new HashMap();
        //headers.put("Authorization", "Bearer " + RoomApplication.getInstance().getAccessToken());
        return headers;
    }
}