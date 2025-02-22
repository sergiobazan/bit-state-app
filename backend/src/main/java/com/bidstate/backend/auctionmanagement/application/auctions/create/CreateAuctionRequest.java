package com.bidstate.backend.auctionmanagement.application.auctions.create;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateAuctionRequest(
        UUID sellerId,
        UUID propertyId,
        LocalDateTime start,
        LocalDateTime end
) {
}
