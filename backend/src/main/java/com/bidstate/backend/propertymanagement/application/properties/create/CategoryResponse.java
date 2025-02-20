package com.bidstate.backend.propertymanagement.application.properties.create;

import java.util.UUID;

public record CategoryResponse(UUID id, String name, String description) {
}
