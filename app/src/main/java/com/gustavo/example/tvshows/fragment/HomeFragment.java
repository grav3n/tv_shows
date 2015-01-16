package com.gustavo.example.tvshows.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;

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
import com.gustavo.example.tvshows.model.TopRated;
import com.gustavo.example.tvshows.model.TopRatedResponse;

import org.json.JSONObject;

import java.util.List;

import javax.security.auth.callback.Callback;

public class HomeFragment extends Fragment{

    private List<TopRated> topRatedList;
    private TopRatedAdapter adapter;
    private GridView gridview;
    private ProgressBar loader;
    private RequestQueue mRequestQueue;
    private static final String TAG = HomeFragment.class
            .getSimpleName();

    public HomeFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        loader = (ProgressBar) view.findViewById(R.id.loading_top_rated);
        gridview = (GridView) view.findViewById(R.id.gridview);

        if (adapter != null) {
            gridview.setAdapter(adapter);
        } else {
            getTopRatedShows(listener, errorListener);
            loader.setVisibility(View.VISIBLE);
        }

        return view;
    }

    public void getTopRatedShows(Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, Constants.TOP_RATED_URL,null,listener, errorListener);
        addToRequestQueue(jsonObjReq, "json_obj_req");
    }

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            if(adapter != null) {
                adapter.clear();
            }
            Log.e(HomeFragment.class.getSimpleName(), error.toString());
            loader.setVisibility(View.GONE);
        }
    };

    Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            if (gridview != null) {
                loader.setVisibility(View.GONE);
                TopRatedResponse resp = new Gson().fromJson(response.toString(), TopRatedResponse.class);
                topRatedList = resp.getResults();
                adapter = new TopRatedAdapter(getActivity(), topRatedList);
                gridview.setAdapter(adapter);
            }

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