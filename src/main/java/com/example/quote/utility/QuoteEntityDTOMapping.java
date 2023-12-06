package com.example.quote.utility;

import com.example.quote.dto.QuoteDataDTO;
import com.example.quote.entity.QuoteEntity;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuoteEntityDTOMapping {
    public List<QuoteDataDTO> mapQuoteEntityToQuoteDataDTOList(List<QuoteEntity> quoteEntityList){
        ArrayList<QuoteDataDTO> quoteDataDTOList = null;
        if(quoteEntityList!=null || !quoteEntityList.isEmpty()) {
            quoteDataDTOList = new ArrayList<>();
            QuoteDataDTO quoteDataDTO;
            for (QuoteEntity quoteEntity : quoteEntityList) {
                quoteDataDTO = new QuoteDataDTO();
                quoteDataDTO.setQuoteId(quoteEntity.getId());
                quoteDataDTO.setContent(quoteEntity.getContent());
                quoteDataDTO.setRating(quoteEntity.getRating());
                quoteDataDTOList.add(quoteDataDTO);
            }
        }
        return quoteDataDTOList;
    }

    public QuoteEntity mapQuoteDataDTOToQuoteEntity(QuoteDataDTO quoteDataDTO){
        QuoteEntity quoteEntity =null;
        if(quoteDataDTO!=null) {
            quoteEntity = new QuoteEntity();
            quoteEntity.setId(quoteDataDTO.getQuoteId());
            quoteEntity.setContent(quoteDataDTO.getContent());
            quoteEntity.setRating(quoteDataDTO.getRating());
        }
        return quoteEntity;
    }

    public QuoteDataDTO mapQuoteEntityToQuoteDataDTO(QuoteEntity quoteEntity){
        QuoteDataDTO quoteDataDTO = null;
        if(quoteEntity!=null) {
            quoteDataDTO = new QuoteDataDTO();
            quoteDataDTO.setQuoteId(quoteEntity.getId());
            quoteDataDTO.setContent(quoteEntity.getContent());
            quoteDataDTO.setRating(quoteEntity.getRating());
        }
        return quoteDataDTO;
    }

}

