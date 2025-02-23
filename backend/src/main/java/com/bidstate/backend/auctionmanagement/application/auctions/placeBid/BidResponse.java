package com.bidstate.backend.auctionmanagement.application.auctions.placeBid;

import com.bidstate.backend.auctionmanagement.application.auctions.create.CreateAuctionResponse;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public record BidResponse(
        UUID id,
        BigDecimal amount,
        Date date,
        CreateAuctionResponse auction
) {
}
