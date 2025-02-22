package com.bidstate.backend.auctionmanagement.application.auctions.getAll;

import com.bidstate.backend.auctionmanagement.application.auctions.AuctionMapper;
import com.bidstate.backend.auctionmanagement.application.auctions.create.CreateAuctionResponse;
import com.bidstate.backend.auctionmanagement.domain.auctions.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GetAllAuctions {
    private final AuctionRepository auctionRepository;

    @Transactional(readOnly = true)
    public List<CreateAuctionResponse> getAll() {
        return auctionRepository.findAll()
                .stream()
                .map(AuctionMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
