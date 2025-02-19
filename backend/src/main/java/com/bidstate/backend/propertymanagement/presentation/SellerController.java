package com.bidstate.backend.propertymanagement.presentation;

import com.bidstate.backend.propertymanagement.application.sellers.getAllSellers.GetAllSellers;
import com.bidstate.backend.propertymanagement.application.sellers.getAllSellers.SellerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sellers")
public class SellerController {
    private final GetAllSellers getAllSellers;

    @GetMapping
    public ResponseEntity<List<SellerResponse>> getAllSellers() {
        final var result = getAllSellers.getAllSellers();
        return ResponseEntity.ok(result);
    }
}
