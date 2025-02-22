package com.bidstate.backend.auctionmanagement.domain.auctions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuctionRepository extends JpaRepository<Auction, UUID> {
}
