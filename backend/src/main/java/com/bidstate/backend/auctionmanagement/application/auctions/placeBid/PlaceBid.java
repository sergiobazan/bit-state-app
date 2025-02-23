package com.bidstate.backend.auctionmanagement.application.auctions.placeBid;

import com.bidstate.backend.auctionmanagement.application.auctions.BidMapper;
import com.bidstate.backend.auctionmanagement.domain.auctions.AuctionRepository;
import com.bidstate.backend.auctionmanagement.domain.auctions.Bid;
import com.bidstate.backend.auctionmanagement.domain.auctions.BidRepository;
import com.bidstate.backend.auctionmanagement.domain.auctions.ValidOfferService;
import com.bidstate.backend.auctionmanagement.domain.buyers.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PlaceBid {
    private final AuctionRepository auctionRepository;
    private final BidRepository bidRepository;
    private final BuyerRepository buyerRepository;
    private final ValidOfferService validOfferService;

    @Transactional
    public BidResponse place(UUID auctionId, BidRequest bidRequest) throws Exception {
        final var buyer = buyerRepository.findById(bidRequest.buyerId());

        if (buyer.isEmpty()) {
            throw new Exception("No buyer found");
        }

        final var auction = auctionRepository.findById(auctionId);

        if (auction.isEmpty()) {
            throw new Exception("No auction found");
        }

        if (!validOfferService.isValid(auction.get().getStartingPrice(), bidRequest.amount())) {
            throw new Exception("Invalid amount");
        }

        final var bid = Bid.builder()
                .amount(bidRequest.amount())
                .auction(auction.get())
                .buyer(buyer.get())
                .build();

        final var bidSaved = bidRepository.save(bid);

        return BidMapper.fromEntity(bidSaved);
    }
}
