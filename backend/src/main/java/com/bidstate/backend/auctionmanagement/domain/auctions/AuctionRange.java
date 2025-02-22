package com.bidstate.backend.auctionmanagement.domain.auctions;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public record AuctionRange(LocalDateTime start, LocalDateTime end) {

    public AuctionRange {
        if (!start.isBefore(end)) {
            throw new IllegalArgumentException("start must be before end");
        }
    }
}
