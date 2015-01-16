package com.gustavo.example.tvshows.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gustavo on 13/01/15.
 */
public class CreatedBy {
    private int id;
    private String name;
    @SerializedName("profile_path")
    private String profilePath;

    public String getProfilePath() {
        return profilePath;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
