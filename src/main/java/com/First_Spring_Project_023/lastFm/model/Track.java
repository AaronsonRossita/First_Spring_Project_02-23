package com.First_Spring_Project_023.lastFm.model;

public class Track {

    private String name;
    private String playcount;
    private String url;

    public Track() {
    }

    public Track(String name, String playcount, String url) {
        this.name = name;
        this.playcount = playcount;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
