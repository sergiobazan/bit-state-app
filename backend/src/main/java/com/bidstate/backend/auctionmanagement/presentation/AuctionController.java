package com.bidstate.backend.auctionmanagement.presentation;

import com.bidstate.backend.auctionmanagement.application.auctions.create.CreateAuction;
import com.bidstate.backend.auctionmanagement.application.auctions.create.CreateAuctionRequest;
import com.bidstate.backend.auctionmanagement.application.auctions.getAll.GetAllAuctions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auctions")
public class AuctionController {
    private final CreateAuction createAuction;
    private final GetAllAuctions getAllAuctions;

    @PostMapping
    ResponseEntity<?> createAuction(@RequestBody CreateAuctionRequest auctionRequest) {
        try {
            final var result = createAuction.create(auctionRequest);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    ResponseEntity<?> getAllAuctions() {
        final var result = getAllAuctions.getAll();
        return ResponseEntity.ok(result);
    }
}
