package com.gustavo.example.tvshows.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gustavo on 30/11/14.
 */
public class TopRatedResponse {
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<TopRated> getResults() {
        return results;
    }

    public void setResults(List<TopRated> results) {
        this.results = results;
    }
    private int page;
    private List<TopRated> results;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("total_results")
    int totalResults;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }



}
