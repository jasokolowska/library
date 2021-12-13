package com.example.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {

    @JsonProperty("id")
    private int id;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("title")
    private Title title;
}
