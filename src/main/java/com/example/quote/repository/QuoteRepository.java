package com.example.quote.repository;

import com.example.quote.entity.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<QuoteEntity, Long> {
    List<QuoteEntity> findTop10ByOrderByRatingDesc();
}
