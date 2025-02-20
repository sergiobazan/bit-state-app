package com.bidstate.backend.propertymanagement.application.properties.create;

import com.bidstate.backend.propertymanagement.application.sellers.getAllSellers.SellerResponse;
import com.bidstate.backend.propertymanagement.domain.properties.PropertyStatus;
import com.bidstate.backend.propertymanagement.domain.properties.PropertyType;

import java.math.BigDecimal;
import java.util.UUID;

public record CreatePropertyResponse(
        UUID id,
        String title,
        String description,
        BigDecimal price,
        String measures,
        PropertyType type,
        PropertyStatus status,
        AddressResponse address,
        CategoryResponse category,
        SellerResponse seller
) {
}
