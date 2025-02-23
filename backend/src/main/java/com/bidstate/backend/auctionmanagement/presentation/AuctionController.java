package com.bidstate.backend.auctionmanagement.presentation;

import com.bidstate.backend.auctionmanagement.application.auctions.create.CreateAuction;
import com.bidstate.backend.auctionmanagement.application.auctions.create.CreateAuctionRequest;
import com.bidstate.backend.auctionmanagement.application.auctions.create.CreateAuctionResponse;
import com.bidstate.backend.auctionmanagement.application.auctions.getAll.GetAllAuctions;
import com.bidstate.backend.auctionmanagement.application.auctions.getById.GetAuctionById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auctions")
public class AuctionController {
    private final CreateAuction createAuction;
    private final GetAllAuctions getAllAuctions;
    private final GetAuctionById GetAuctionById;

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

    @GetMapping("{id}")
    ResponseEntity<?> getById(@PathVariable UUID id) {
        try {
            final CreateAuctionResponse result = GetAuctionById.getById(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
