package com.gustavo.example.tvshows.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gustavo on 13/01/15.
 */
public class Show {
    private int id;
    @SerializedName("first_air_date")
    private String firstAirDate;
    @SerializedName("last_air_date")
    private String lastAirDate;
    private String name;
    @SerializedName("number_of_episodes")
    private int numberOfEpisodes;
    @SerializedName("number_of_seasons")
    private int numberOfSeasons;
    @SerializedName("original_language")
    private String originalLanguage;
    private String overview;
    private Float popularity;
    @SerializedName("poster_path")
    private String posterPath;
    private String status;
    private String homepage;
    @SerializedName("created_by")
    private List<CreatedBy> createdBy;
    private List<Genres> genres;
    private List<Season> seasons;

    public int getId() {
        return id;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOverview() {
        return overview;
    }

    public Float getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getStatus() {
        return status;
    }

    public String getHomepage() {
        return homepage;
    }

    public List<CreatedBy> getCreatedBy() {
        return createdBy;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public List<Season> getSeasons() {
        return seasons;
    }
}

