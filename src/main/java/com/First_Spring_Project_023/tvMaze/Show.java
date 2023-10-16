package com.First_Spring_Project_023.tvMaze;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Show {

    private Integer id;
    private String name;
    @JsonProperty("url")
    private String pictureURL;

    public Show(Integer id, String name, String pictureURL) {
        this.id = id;
        this.name = name;
        this.pictureURL = pictureURL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}





