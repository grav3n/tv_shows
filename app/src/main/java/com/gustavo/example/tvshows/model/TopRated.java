package com.gustavo.example.tvshows.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gustavo on 30/11/14.
 */
public class TopRated {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }


    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    private int id;
    private String name;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("original_name")
    private String originalName;
    @SerializedName("first_air_date")
    private String firstAirDate;
    @SerializedName("vote_average")
    private float voteAverage;
    @SerializedName("vote_count")
    private int vote_count;
    @SerializedName("popularity")
    private float popularity;
}
