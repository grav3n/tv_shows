package com.gustavo.example.tvshows.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gustavo on 13/01/15.
 */
public class Season {
    private int id;
    @SerializedName("air_date")
    private String airDate;
    @SerializedName("season_number")
    private int seasonNumber;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("episode_count")
    private int episodeCount;

    public int getEpisodeCount() {
        return episodeCount;
    }

    public String getAirDate() {
        return airDate;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public int getId() {
        return id;
    }
}
