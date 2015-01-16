package com.gustavo.example.tvshows.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gustavo.example.tvshows.Constants;
import com.gustavo.example.tvshows.R;
import com.gustavo.example.tvshows.fragment.DetailFragment;
import com.gustavo.example.tvshows.fragment.HomeFragment;
import com.gustavo.example.tvshows.model.TopRated;
import com.gustavo.example.tvshows.view.UrlImageView;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gustavo on 30/11/14.
 */
public class TopRatedAdapter extends ArrayAdapter<TopRated> {

    private Activity context;
    private List<TopRated> topRatedList = new ArrayList<TopRated>();

    public TopRatedAdapter(Activity context, List<TopRated> topRatedList) {
        super(context, R.layout.item_home, topRatedList);
        this.context = context;
        this.topRatedList = topRatedList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_home, null);

        try {
            UrlImageView urlImg = (UrlImageView) convertView.findViewById(R.id.sample_image);
            Picasso.with(context).load(Constants.TOP_RATED_IMAGE_PATH + topRatedList.get(position).getPosterPath()).into(urlImg);
            //urlImg.setImageURL(new URL(Constants.TOP_RATED_IMAGE_PATH + topRatedList.get(position).getPosterPath()));
            urlImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
            TextView showTitle = (TextView) convertView.findViewById(R.id.show_title);
            showTitle.setText(topRatedList.get(position).getName());

            final int id = topRatedList.get(position).getId();
            urlImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle arguments = new Bundle();
                    arguments.putInt(DetailFragment.ARG_ITEM_ID,id);
                    DetailFragment fragment = new DetailFragment();
                    fragment.setArguments(arguments);
                    //getActionBar().setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);
                    //getActionBar().setDisplayShowTitleEnabled(true);
                    //getActionBar().setTitle(R.string.title_room_detail);
                    context.getFragmentManager().beginTransaction()
                            .replace(R.id.content, fragment).addToBackStack(null)
                            .commit();
                }
            });
        }catch (Exception e){

        }


        return convertView;
    }
}
