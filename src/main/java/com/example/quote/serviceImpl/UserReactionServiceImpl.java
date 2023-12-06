package com.example.quote.serviceImpl;

import com.example.quote.entity.QuoteEntity;
import com.example.quote.repository.QuoteRepository;
import com.example.quote.service.UserReactionService;
import com.example.quote.utility.QuoteEntityDTOMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserReactionServiceImpl implements UserReactionService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private QuoteEntityDTOMapping quoteEntityDTOMapping;

    /**
     * @param quoteId
     */
    @Override
    public void userLikedQuote(Long quoteId) {
        QuoteEntity quoteEntity = quoteRepository.findById(quoteId).orElse(null);
        if (quoteEntity != null) {
            // Increment the like count or handle the like logic here
            quoteEntity.setRating(quoteEntity.getRating() + 1);
            quoteRepository.save(quoteEntity);
        }
    }
}
