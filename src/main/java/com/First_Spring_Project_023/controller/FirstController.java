package com.First_Spring_Project_023.controller;

import com.First_Spring_Project_023.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/first")
public class FirstController {

    // Create Read Update Delete
    //  POST  GET   PUT   DELETE

    @GetMapping(value = "/first_get")
    public static String firstGet(){
        return "This is the first get";
    }

    @GetMapping(value = "/second_get/{name}")
    public static String secondGet(@PathVariable String name){
        return "You wrote " + name;
    }

    @GetMapping(value = "/third_get")
    public static String thirdGet(@RequestParam String name){
        return "You sent me this name " + name;
    }

    @GetMapping(value = "/fourth_get")
    public static String fourthGet(@RequestParam int id){
        return "You sent me this id " + id;
    }

    @PostMapping(value = "first_post")
    public static String firstPost(@RequestBody String name){
        return "You posted this name : " + name;
    }

    @PostMapping(value = "second_post")
    public static String secondPost(@RequestBody Customer customer){
        return customer.toString();
    }


}
