package com.bidstate.backend.auctionmanagement.application.auctions.close;

import com.bidstate.backend.auctionmanagement.domain.auctions.AuctionRepository;
import com.bidstate.backend.auctionmanagement.domain.buyers.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CloseAuction {
    private final AuctionRepository auctionRepository;
    private final BuyerRepository buyerRepository;

    @Transactional
    public void closeAuction(UUID id, CloseAuctionRequest auctionRequest) throws Exception {
        final var auction = auctionRepository.findById(id);

        if (auction.isEmpty()) {
            throw new Exception("No auction found");
        }

        final var winner = buyerRepository.findById(auctionRequest.winnerId());

        if (winner.isEmpty()) {
            throw new Exception("No winner found");
        }

        try {
            auction.get().close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        auction.get().assignWinner(winner.get());

        auctionRepository.save(auction.get());
    }
}
