package com.First_Spring_Project_023.secondMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class SecondController {

    @Autowired
    private SecondSpringProjectService secondSpringProjectService;

    @GetMapping
    String getStringFromSecondMicroService(){
        return secondSpringProjectService.getStringFromSecondMicroService();
    }

}
