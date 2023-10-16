package com.First_Spring_Project_023.lastFm;

import com.First_Spring_Project_023.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LastFmController {

    @Autowired
    private LastFmService lastFmService;

    @GetMapping
    void getTopTrackByArtist(@RequestParam String artist){
        lastFmService.getTopTrackByArtist(Constants.LAST_FM_METHOD_TOP_TRACKS,Constants.LAST_FM_KEY,Constants.LAST_FM_FORMAT,artist);
    }

}
