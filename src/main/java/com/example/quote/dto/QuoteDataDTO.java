package com.example.quote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

//TODO : Use lombok
public class QuoteDataDTO {
    @JsonProperty("content")
    private  String content;
    @JsonProperty("quoteId")
    private Long quoteId;

    @JsonProperty("rating")
    private int rating;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
