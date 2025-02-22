package com.bidstate.backend.auctionmanagement.application.auctions.create;

import com.bidstate.backend.auctionmanagement.application.auctions.AuctionMapper;
import com.bidstate.backend.auctionmanagement.domain.auctions.Auction;
import com.bidstate.backend.auctionmanagement.domain.auctions.AuctionRange;
import com.bidstate.backend.auctionmanagement.domain.auctions.AuctionRepository;
import com.bidstate.backend.auctionmanagement.domain.auctions.AuctionStatus;
import com.bidstate.backend.propertymanagement.domain.properties.PropertyRepository;
import com.bidstate.backend.propertymanagement.domain.sellers.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class CreateAuction {
    private final AuctionRepository auctionRepository;
    private final SellerRepository sellerRepository;
    private final PropertyRepository propertyRepository;

    @Transactional
    public CreateAuctionResponse create(CreateAuctionRequest auctionRequest) throws Exception {
        final var seller = sellerRepository.findById(auctionRequest.sellerId());

        if (seller.isEmpty()) {
            throw new Exception("no seller found");
        }

        final var property = propertyRepository.findById(auctionRequest.propertyId());

        if (property.isEmpty()) {
            throw new Exception("no property found");
        }

        final var range = new AuctionRange(auctionRequest.start(), auctionRequest.end());

        final var auction = Auction.builder()
                .startingPrice(property.get().getPrice())
                .status(AuctionStatus.ACTIVE)
                .rangeTime(range)
                .seller(seller.get())
                .property(property.get())
                .build();

        final var auctionSaved = auctionRepository.save(auction);

        return AuctionMapper.fromEntity(auctionSaved);
    }
}
