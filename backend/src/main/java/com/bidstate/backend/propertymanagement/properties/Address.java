package com.bidstate.backend.propertymanagement.properties;

import jakarta.persistence.Embeddable;

@Embeddable
public record Address(
        String street,
        String city,
        String state
) {
}
