package com.bidstate.backend.auctionmanagement.domain.auctions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BidRepository extends JpaRepository<Bid, UUID> {
    List<Bid> findAllByAuction(Auction auction);
}
