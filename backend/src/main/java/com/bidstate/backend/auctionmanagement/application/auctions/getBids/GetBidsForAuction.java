package com.bidstate.backend.auctionmanagement.application.auctions.getBids;

import com.bidstate.backend.auctionmanagement.application.auctions.BidMapper;
import com.bidstate.backend.auctionmanagement.application.auctions.placeBid.BidResponse;
import com.bidstate.backend.auctionmanagement.domain.auctions.AuctionRepository;
import com.bidstate.backend.auctionmanagement.domain.auctions.BidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GetBidsForAuction {
    private final AuctionRepository auctionRepository;
    private final BidRepository bidRepository;

    @Transactional(readOnly = true)
    public List<BidResponse> getBids(final UUID auctionId) throws Exception {
        final var auction = auctionRepository.findById(auctionId);

        if (auction.isEmpty()) {
            throw new Exception("No auction found");
        }
        final var bids = bidRepository.findAllByAuction(auction.get());

        return bids.stream().map(BidMapper::fromEntity).collect(Collectors.toList());
    }
}
