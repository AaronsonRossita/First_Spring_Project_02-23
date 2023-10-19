package com.First_Spring_Project_023.secondMicroService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "secondSpringProjectService",
        url = "${second_micro_service.url}"
)
public interface SecondSpringProjectService {

    @GetMapping
    String getStringFromSecondMicroService();

}
