package com.bidstate.backend.auctionmanagement.application.auctions.placeBid;

import java.math.BigDecimal;
import java.util.UUID;

public record BidRequest(
        UUID buyerId,
        BigDecimal amount
) {
}
