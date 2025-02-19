package com.bidstate.backend.propertymanagement.application.sellers.getAllSellers;

import com.bidstate.backend.propertymanagement.application.sellers.SellerMapper;
import com.bidstate.backend.propertymanagement.domain.sellers.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllSellers {
    private final SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public List<SellerResponse> getAllSellers() {
        return sellerRepository.findAll().stream()
                .map(SellerMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
