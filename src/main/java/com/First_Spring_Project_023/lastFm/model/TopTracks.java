package com.First_Spring_Project_023.lastFm.model;


public class TopTracks {

    private Track[] track;

    public TopTracks() {
    }

    public TopTracks(Track[] track) {
        this.track = track;
    }

    public Track[] getTrack() {
        return track;
    }

    public void setTrack(Track[] track) {
        this.track = track;
    }
}
