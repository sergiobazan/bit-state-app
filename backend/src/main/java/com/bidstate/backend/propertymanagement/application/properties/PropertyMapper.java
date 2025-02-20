package com.bidstate.backend.propertymanagement.application.properties;

import com.bidstate.backend.propertymanagement.application.properties.create.AddressResponse;
import com.bidstate.backend.propertymanagement.application.properties.create.CategoryResponse;
import com.bidstate.backend.propertymanagement.application.properties.create.CreatePropertyResponse;
import com.bidstate.backend.propertymanagement.application.sellers.getAllSellers.SellerResponse;
import com.bidstate.backend.propertymanagement.domain.properties.Property;

public class PropertyMapper {
    public static CreatePropertyResponse fromEntity(final Property property) {
        return new CreatePropertyResponse(
                property.getId(),
                property.getTitle(),
                property.getDescription(),
                property.getPrice(),
                property.getMeasures(),
                property.getType(),
                property.getStatus(),
                new AddressResponse(
                        property.getAddress().city(),
                        property.getAddress().street(),
                        property.getAddress().state()
                ),
                new CategoryResponse(
                        property.getCategory().getId(),
                        property.getCategory().getName(),
                        property.getCategory().getDescription()
                ),
                new SellerResponse(
                        property.getSeller().getId(),
                        property.getSeller().getName(),
                        property.getSeller().getEmail(),
                        property.getSeller().getPhoneNumber()
                )
        );
    }
}
