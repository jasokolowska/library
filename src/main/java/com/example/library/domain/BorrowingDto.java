package com.example.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BorrowingDto {

    @JsonProperty("id")
    private int id;
    @JsonProperty("bookId")
    private int bookId;
    @JsonProperty("readerId")
    private int readerId;

    @JsonProperty("borrowDate")
    private Date borrowDate;
    @JsonProperty("returnDate")
    private Date returnDate;
}
