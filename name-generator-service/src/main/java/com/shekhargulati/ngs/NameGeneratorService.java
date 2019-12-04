package com.shekhargulati.ngs;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static strman.Strman.toKebabCase;

@SpringBootApplication
public class NameGeneratorService {

    public static void main(String[] args) {
        SpringApplication.run(NameGeneratorService.class, args);
    }

}

@RestController
@RequestMapping("/api/v1/names")
@EnableFeignClients
class NameResource {

    OkHttpClient client = new OkHttpClient();

    @Autowired
    private AnimalService animalService;

    @Autowired
    private ScientistService scientistService;


    @GetMapping(path = "/random")
    public String name() throws Exception {

        String scientist = scientistService.scientists();
        String animal = animalService.animals();

        String name = toKebabCase(scientist) + "-" + toKebabCase(animal);
        return name;
    }

    private String makeRequest(String url) throws IOException {
        Request.Builder requestBuilder = new Request.Builder()
                .url(url);

        Request request = requestBuilder
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


}