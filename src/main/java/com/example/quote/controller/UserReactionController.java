package com.example.quote.controller;

import com.example.quote.service.UserReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserReactionController {
    @Autowired
    private UserReactionService userReactionService;

    @PostMapping("/like/{quoteId}")
    public ResponseEntity<String> userLikedQuote(@PathVariable Long quoteId) {
        userReactionService.userLikedQuote(quoteId);
        return ResponseEntity.ok("Quote liked successfully. QuoteID :" + quoteId );
    }






}
