package com.First_Spring_Project_023.lastFm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "lastFmService",
        url = "https://ws.audioscrobbler.com/2.0/"
)
public interface LastFmService {

    @GetMapping
    void getTopTrackByArtist(@RequestParam String method, @RequestParam String api_key,@RequestParam String format, @RequestParam String artist);

}
