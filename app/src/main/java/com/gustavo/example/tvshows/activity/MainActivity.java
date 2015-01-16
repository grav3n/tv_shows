package com.gustavo.example.tvshows.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
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
import com.gustavo.example.tvshows.fragment.DetailFragment;
import com.gustavo.example.tvshows.fragment.HomeFragment;
import com.gustavo.example.tvshows.model.TopRated;
import com.gustavo.example.tvshows.model.TopRatedResponse;

import org.json.JSONObject;

import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getFragmentManager().beginTransaction()
                .replace(R.id.content, new HomeFragment()).addToBackStack(null)
                .commit();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
