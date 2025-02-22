package com.bidstate.backend.auctionmanagement.application.auctions;

import com.bidstate.backend.auctionmanagement.application.auctions.create.CreateAuctionResponse;
import com.bidstate.backend.auctionmanagement.domain.auctions.Auction;
import com.bidstate.backend.propertymanagement.application.properties.create.AddressResponse;
import com.bidstate.backend.propertymanagement.application.properties.create.CategoryResponse;
import com.bidstate.backend.propertymanagement.application.properties.create.CreatePropertyResponse;
import com.bidstate.backend.propertymanagement.application.sellers.getAllSellers.SellerResponse;

public class AuctionMapper {
    public static CreateAuctionResponse fromEntity(Auction auctionSaved) {
        return new CreateAuctionResponse(
                auctionSaved.getId(),
                auctionSaved.getStartingPrice(),
                auctionSaved.getRangeTime(),
                auctionSaved.getStatus(),
                new SellerResponse(
                        auctionSaved.getSeller().getId(),
                        auctionSaved.getSeller().getName(),
                        auctionSaved.getSeller().getEmail(),
                        auctionSaved.getSeller().getPhoneNumber()
                ),
                new CreatePropertyResponse(
                        auctionSaved.getProperty().getId(),
                        auctionSaved.getProperty().getTitle(),
                        auctionSaved.getProperty().getDescription(),
                        auctionSaved.getProperty().getPrice(),
                        auctionSaved.getProperty().getMeasures(),
                        auctionSaved.getProperty().getType(),
                        auctionSaved.getProperty().getStatus(),
                        new AddressResponse(
                                auctionSaved.getProperty().getAddress().city(),
                                auctionSaved.getProperty().getAddress().street(),
                                auctionSaved.getProperty().getAddress().state()
                        ),
                        new CategoryResponse(
                                auctionSaved.getProperty().getCategory().getId(),
                                auctionSaved.getProperty().getCategory().getName(),
                                auctionSaved.getProperty().getCategory().getDescription()
                        ),
                        null
                )
        );
    }
}
