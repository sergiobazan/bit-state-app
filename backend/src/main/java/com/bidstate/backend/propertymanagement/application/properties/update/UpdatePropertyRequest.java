package com.bidstate.backend.propertymanagement.application.properties.update;

import com.bidstate.backend.propertymanagement.domain.properties.PropertyStatus;
import com.bidstate.backend.propertymanagement.domain.properties.PropertyType;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdatePropertyRequest(
        String title,
        String description,
        BigDecimal price,
        String measures,
        PropertyType type,
        PropertyStatus status,
        String city,
        String street,
        String  state,
        UUID sellerId,
        UUID categoryId
) {
}
