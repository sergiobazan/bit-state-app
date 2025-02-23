package com.bidstate.backend.auctionmanagement.application.auctions.close;

import java.util.UUID;

public record CloseAuctionRequest(UUID winnerId) {
}
