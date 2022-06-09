package com.bm402.springplayground.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceData {
    @JsonAlias("place name")
    String name;
    String longitude;
    String state;
    @JsonAlias("state abbreviation")
    String stateCode;
    String latitude;
}
