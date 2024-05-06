package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Price;
import com.example.demo.service.PriceService;

@RestController
@RequestMapping("/prices")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping
    public ResponseEntity<Price> getPrice(@RequestParam Long brandId,
                                          @RequestParam Long productId,
                                          @RequestParam String date) {
        // Convertir la cadena de fecha a LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(date);

        Price price = priceService.getPriceForProductAndBrandAndDate(brandId, productId, dateTime);
        if (price != null) {
            return ResponseEntity.ok(price);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
