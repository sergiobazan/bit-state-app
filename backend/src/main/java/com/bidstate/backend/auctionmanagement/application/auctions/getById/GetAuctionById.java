package com.bidstate.backend.auctionmanagement.application.auctions.getById;

import com.bidstate.backend.auctionmanagement.application.auctions.AuctionMapper;
import com.bidstate.backend.auctionmanagement.application.auctions.create.CreateAuctionResponse;
import com.bidstate.backend.auctionmanagement.domain.auctions.Auction;
import com.bidstate.backend.auctionmanagement.domain.auctions.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetAuctionById {
    private final AuctionRepository auctionRepository;

    @Transactional(readOnly = true)
    public CreateAuctionResponse getById(UUID id) throws Exception {
        final Auction auction = auctionRepository.findById(id).orElseThrow(() -> new Exception("No auction found"));
        return AuctionMapper.fromEntity(auction);
    }
}
