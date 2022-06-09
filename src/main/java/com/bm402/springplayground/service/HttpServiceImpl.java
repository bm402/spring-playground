package com.bm402.springplayground.service;

import com.bm402.springplayground.model.PostcodeData;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class HttpServiceImpl implements HttpService {
    private final WebClient client;

    public HttpServiceImpl(String baseUrl) {
        client = WebClient.create(baseUrl);
    }

    public Mono<PostcodeData> getPostcodeData(String postcode) {
        return client.get()
                .uri("/gb/"+postcode)
                .retrieve()
                .bodyToMono(PostcodeData.class);
    }
}
