package com.bidstate.backend.propertymanagement.application.sellers.getAllSellers;

import java.util.UUID;

public record SellerResponse(UUID id, String name, String email, String phoneNumber) {
}
