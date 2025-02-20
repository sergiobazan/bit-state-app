package com.bidstate.backend.propertymanagement.application.property.create;

import com.bidstate.backend.propertymanagement.domain.properties.PropertyStatus;
import com.bidstate.backend.propertymanagement.domain.properties.PropertyType;

import java.math.BigDecimal;
import java.util.UUID;

public record CreatePropertyRequest(
        String title,
        String description,
        BigDecimal price,
        String measures,
        PropertyType type,
        PropertyStatus status,
        String city,
        String street,
        String  state,
        UUID categoryId,
        UUID sellerId
) {
}
