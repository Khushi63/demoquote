package com.example.quote.serviceImpl;

import com.example.quote.dto.QuoteDataDTO;
import com.example.quote.entity.QuoteEntity;
import com.example.quote.repository.QuoteRepository;
import com.example.quote.utility.QuoteEntityDTOMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.example.quote.service.QuoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuoteServiceImpl implements QuoteService {
    private final RestTemplate restTemplate;
    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private QuoteEntityDTOMapping quoteEntityDTOMapping;
    private static final String QUOTE_API = "https://api.quotable.io/random";




    public QuoteServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * @return
     */
    @Override
    public QuoteDataDTO getNewRandomQuote()  {
        QuoteDataDTO quoteDataDTO = getNewRandomQuoteFromAPI();
        return saveQuoteDTOToDB(quoteDataDTO);
    }
    /**
     * @return
     */
    @Override
    public QuoteDataDTO getHighlyRatedRandomQuote() {
        List<QuoteDataDTO> highlyRatedQuotes= quoteEntityDTOMapping.mapQuoteEntityToQuoteDataDTOList(quoteRepository.findTop10ByOrderByRatingDesc());
        if (!highlyRatedQuotes.isEmpty()) {
            int randomIndex = new Random().nextInt(highlyRatedQuotes.size());
            return highlyRatedQuotes.get(randomIndex);
        } else {
            // get random quote from the external API if there are no quotes
            QuoteDataDTO randomQuote = getNewRandomQuoteFromAPI();
            return saveQuoteDTOToDB(randomQuote);
        }
    }
    private QuoteDataDTO getNewRandomQuoteFromAPI(){
        ResponseEntity<QuoteDataDTO> response = restTemplate.getForEntity(QUOTE_API, QuoteDataDTO.class);
        QuoteDataDTO quoteDataDTO = response.getBody();
        return quoteDataDTO;
    }
    private QuoteDataDTO saveQuoteDTOToDB(QuoteDataDTO quoteDataDTO){
        QuoteEntity quoteEntity = quoteEntityDTOMapping.mapQuoteDataDTOToQuoteEntity(quoteDataDTO);
        QuoteEntity savedQuote = quoteRepository.save(quoteEntity);
        return quoteEntityDTOMapping.mapQuoteEntityToQuoteDataDTO(savedQuote);
    }

}
