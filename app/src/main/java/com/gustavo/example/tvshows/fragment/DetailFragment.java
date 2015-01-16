package com.gustavo.example.tvshows.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.gustavo.example.tvshows.Constants;
import com.gustavo.example.tvshows.R;
import com.gustavo.example.tvshows.adapter.TopRatedAdapter;
import com.gustavo.example.tvshows.model.Show;
import com.gustavo.example.tvshows.model.TopRatedResponse;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class DetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private RequestQueue mRequestQueue;
    private Show show;
    private static final String TAG = HomeFragment.class
            .getSimpleName();
    TextView showName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            getShow(getArguments().getInt(ARG_ITEM_ID),listener,errorListener);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        showName = (TextView)view.findViewById(R.id.show_name);

        return view;
    }

    public void getShow(int id,Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, Constants.SHOW_URL + id + Constants.API_KEY,null,listener, errorListener);
        addToRequestQueue(jsonObjReq, "json_obj_req");
    }

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
        }
    };

    Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            Log.e(DetailFragment.class.getSimpleName(), response.toString());
            Show show = new Gson().fromJson(response.toString(), Show.class);
            showName.setText(show.getName());
        }
    };

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getActivity());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }
}
