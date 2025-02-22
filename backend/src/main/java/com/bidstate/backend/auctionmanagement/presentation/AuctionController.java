package com.bidstate.backend.auctionmanagement.presentation;

import com.bidstate.backend.auctionmanagement.application.auctions.create.CreateAuction;
import com.bidstate.backend.auctionmanagement.application.auctions.create.CreateAuctionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auctions")
public class AuctionController {
    private final CreateAuction createAuction;

    @PostMapping
    ResponseEntity<?> createAuction(@RequestBody CreateAuctionRequest auctionRequest) {
        try {
            final var result = createAuction.create(auctionRequest);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
