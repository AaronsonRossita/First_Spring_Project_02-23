package com.First_Spring_Project_023.lastFm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastFmResponse {

    @JsonProperty("toptracks")
    private TopTracks topTracks;

    public LastFmResponse() {
    }

    public LastFmResponse(TopTracks topTracks) {
        this.topTracks = topTracks;
    }

    public TopTracks getTopTracks() {
        return topTracks;
    }

    public void setTopTracks(TopTracks topTracks) {
        this.topTracks = topTracks;
    }
}
