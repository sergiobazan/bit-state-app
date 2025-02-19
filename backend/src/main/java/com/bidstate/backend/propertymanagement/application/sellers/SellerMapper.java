package com.bidstate.backend.propertymanagement.application.sellers;

import com.bidstate.backend.propertymanagement.application.sellers.getAllSellers.SellerResponse;
import com.bidstate.backend.propertymanagement.domain.sellers.Seller;

public class SellerMapper {
    public static SellerResponse fromEntity(Seller seller) {
        return new SellerResponse(
                seller.getId(),
                seller.getName(),
                seller.getEmail(),
                seller.getPhoneNumber()
        );
    }
}
