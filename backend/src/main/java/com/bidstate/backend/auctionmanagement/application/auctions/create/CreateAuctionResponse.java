package com.bidstate.backend.auctionmanagement.application.auctions.create;

import com.bidstate.backend.auctionmanagement.domain.auctions.AuctionRange;
import com.bidstate.backend.auctionmanagement.domain.auctions.AuctionStatus;
import com.bidstate.backend.propertymanagement.application.properties.create.CreatePropertyResponse;
import com.bidstate.backend.propertymanagement.application.sellers.getAllSellers.SellerResponse;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateAuctionResponse(
        UUID id,
        BigDecimal startingPrice,
        AuctionRange range,
        AuctionStatus status,
        SellerResponse seller,
        CreatePropertyResponse property
) {
}
