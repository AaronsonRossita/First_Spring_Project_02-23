package com.First_Spring_Project_023.lastFm;

import com.First_Spring_Project_023.lastFm.model.LastFmResponse;
import com.First_Spring_Project_023.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/top_tracks")
public class LastFmController {

    @Autowired
    private LastFmService lastFmService;

    @GetMapping(value = "/by_artist")
    LastFmResponse getTopTracksByArtist(@RequestParam String artist){
        return lastFmService.getArtistDataFromLastFm(
                Constants.LAST_FM_METHOD_TOP_TRACKS,
                Constants.LAST_FM_KEY,
                Constants.LAST_FM_FORMAT,
                artist);
    }


}
