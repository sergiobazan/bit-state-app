package com.bidstate.backend.auctionmanagement.application.auctions;

import com.bidstate.backend.auctionmanagement.application.auctions.create.CreateAuctionResponse;
import com.bidstate.backend.auctionmanagement.application.auctions.placeBid.BidResponse;
import com.bidstate.backend.auctionmanagement.domain.auctions.Bid;
import com.bidstate.backend.propertymanagement.application.properties.create.AddressResponse;
import com.bidstate.backend.propertymanagement.application.properties.create.CategoryResponse;
import com.bidstate.backend.propertymanagement.application.properties.create.CreatePropertyResponse;
import com.bidstate.backend.propertymanagement.application.sellers.getAllSellers.SellerResponse;

public class BidMapper {
    public static BidResponse fromEntity(final Bid bid) {
        return new BidResponse(
                bid.getId(),
                bid.getAmount(),
                bid.getCreatedDate(),
                new CreateAuctionResponse(
                        bid.getAuction().getId(),
                        bid.getAuction().getStartingPrice(),
                        bid.getAuction().getRangeTime(),
                        bid.getAuction().getStatus(),
                        new SellerResponse(
                                bid.getAuction().getSeller().getId(),
                                bid.getAuction().getSeller().getName(),
                                bid.getAuction().getSeller().getEmail(),
                                bid.getAuction().getSeller().getPhoneNumber()
                        ),
                        new CreatePropertyResponse(
                                bid.getAuction().getProperty().getId(),
                                bid.getAuction().getProperty().getTitle(),
                                bid.getAuction().getProperty().getDescription(),
                                bid.getAuction().getProperty().getPrice(),
                                bid.getAuction().getProperty().getMeasures(),
                                bid.getAuction().getProperty().getType(),
                                bid.getAuction().getProperty().getStatus(),
                                new AddressResponse(
                                        bid.getAuction().getProperty().getAddress().city(),
                                        bid.getAuction().getProperty().getAddress().street(),
                                        bid.getAuction().getProperty().getAddress().state()
                                ),
                                new CategoryResponse(
                                        bid.getAuction().getProperty().getCategory().getId(),
                                        bid.getAuction().getProperty().getCategory().getName(),
                                        bid.getAuction().getProperty().getCategory().getDescription()
                                ),
                                null
                        )
                )
        );
    }
}
