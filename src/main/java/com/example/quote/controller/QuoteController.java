package com.example.quote.controller;

import com.example.quote.dto.QuoteDataDTO;
import com.example.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {
    @Autowired
    private QuoteService quoteService;

    @GetMapping(value = {"/getNewRandomQuote"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuoteDataDTO> getNewRandomQuote(){
        QuoteDataDTO restQuoteData = quoteService.getNewRandomQuote();
        if (restQuoteData == null || restQuoteData.getContent().isEmpty()) {
            return new ResponseEntity<>(restQuoteData, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(restQuoteData, HttpStatus.OK);
    }

    @GetMapping(value = {"/getHighlyRatedRandomQuote"})
    public ResponseEntity<QuoteDataDTO> getHighlyRatedRandomQuote(){
        QuoteDataDTO restQuoteData = quoteService.getHighlyRatedRandomQuote();
        if (restQuoteData == null || restQuoteData.getContent().isEmpty()) {
            return new ResponseEntity<>(restQuoteData, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(restQuoteData, HttpStatus.OK);
    }
}
