package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);
}