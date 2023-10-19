package com.First_Spring_Project_023.lastFm;

import com.First_Spring_Project_023.lastFm.model.LastFmResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "lastFmService",
        url = "${lastfm.url}"
)
public interface LastFmService {

    @GetMapping
    LastFmResponse getArtistDataFromLastFm(@RequestParam String method, @RequestParam String api_key, @RequestParam String format, @RequestParam String artist);

}
