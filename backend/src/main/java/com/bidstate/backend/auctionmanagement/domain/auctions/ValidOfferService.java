package com.bidstate.backend.auctionmanagement.domain.auctions;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ValidOfferService {

    public boolean isValid(BigDecimal price, BigDecimal offer) {
        // 5%
        final double MIN_AMOUNT_PERCENTAGE = 0.05;

        final var minPrice = Math.round(price.doubleValue() * MIN_AMOUNT_PERCENTAGE);

        return (price.longValue() + minPrice) < offer.longValue();
    }
}
