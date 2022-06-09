package com.bm402.springplayground.service;

import com.bm402.springplayground.model.PostcodeData;
import reactor.core.publisher.Mono;

public interface HttpService {
    Mono<PostcodeData> getPostcodeData(String postcode);
}
