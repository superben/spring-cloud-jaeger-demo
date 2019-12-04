package com.shekhargulati.ngs;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "animals", url = "http://localhost:9000/")
public interface AnimalService {
    @RequestMapping(value = "api/v1/animals/random", method = RequestMethod.GET)
    String animals();

}
