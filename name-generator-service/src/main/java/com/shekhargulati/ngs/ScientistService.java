package com.shekhargulati.ngs;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name= "scientists", url = "http://localhost:8090/")
public interface ScientistService {
    @RequestMapping(value = "api/v1/scientists/random", method = RequestMethod.GET)
    String scientists();

}
