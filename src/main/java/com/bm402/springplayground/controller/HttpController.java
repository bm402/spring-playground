package com.bm402.springplayground.controller;

import com.bm402.springplayground.model.PostcodeData;
import com.bm402.springplayground.service.HttpService;
import com.bm402.springplayground.service.HttpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("http")
@Slf4j
public class HttpController {
    private final HttpService httpService = new HttpServiceImpl("https://api.zippopotam.us");

    @GetMapping("postcode/{postcode}")
    public ResponseEntity<Mono<PostcodeData>> getPostcodeData(@PathVariable String postcode) {
        Mono<PostcodeData> postcodeDataMono = httpService.getPostcodeData(postcode);
        log.info("Queried Zippopotam.us API regarding postcode data for {}", postcode);

        return ResponseEntity.ok(postcodeDataMono);
    }
}
