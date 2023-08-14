package com.First_Spring_Project_023.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstController {


    @GetMapping(value = "/hello")
    public static String getFunction(){
        return "Hi";
    }

    @GetMapping(value = "/return/{s}")
    public static String returnFunction(@PathVariable String s){
        System.out.println("STRING");
        return s;
    }


}
