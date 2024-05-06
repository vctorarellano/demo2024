package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Price;
import com.example.demo.repository.PriceRepository;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    public Price getPriceForProductAndBrandAndDate(Long brandId, Long productId, LocalDateTime date) {
        List<Price> prices = priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                brandId, productId, date, date);
        if (!prices.isEmpty()) {
            return prices.get(0);
        }
        return null;
    }
}