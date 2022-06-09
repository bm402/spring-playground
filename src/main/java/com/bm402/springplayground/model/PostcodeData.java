package com.bm402.springplayground.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostcodeData {
    @JsonAlias("post code")
    String postcode;
    String country;
    @JsonAlias("country abbreviation")
    String countryCode;
    List<PlaceData> places;
}
