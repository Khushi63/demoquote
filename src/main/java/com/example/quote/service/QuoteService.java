package com.example.quote.service;

import com.example.quote.dto.QuoteDataDTO;

import java.io.IOException;


public interface QuoteService {
    QuoteDataDTO getNewRandomQuote();
    QuoteDataDTO getHighlyRatedRandomQuote();
}
