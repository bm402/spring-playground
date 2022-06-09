package com.bm402.springplayground.service;

import com.bm402.springplayground.model.PlaceData;
import com.bm402.springplayground.model.PostcodeData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.util.List;

public class HttpServiceImplTest {
    private static MockWebServer mockWebServer;
    private HttpService httpService;

    @BeforeAll
    static void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @BeforeEach
    void setUpTest() {
        httpService = new HttpServiceImpl("http://localhost:"+mockWebServer.getPort());
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void whenInputIsCorrectPostcode_thenShouldReturnPostcodeData() throws JsonProcessingException {
        PostcodeData mockPostcodeData = PostcodeData.builder()
                .postcode("TW15")
                .country("Great Britain")
                .countryCode("GB")
                .places(List.of(PlaceData.builder()
                        .name("Ashford")
                        .state("Surrey")
                        .build()))
                .build();

        mockWebServer.enqueue(new MockResponse()
                .setBody(new ObjectMapper().writeValueAsString(mockPostcodeData))
                .addHeader("Content-Type", "application/json"));

        Mono<PostcodeData> postcodeDataMono = httpService.getPostcodeData("TW15");

        StepVerifier.create(postcodeDataMono)
                .expectNextMatches(postcodeData -> postcodeData.getPostcode().equals("TW15"))
                .verifyComplete();
    }
}
