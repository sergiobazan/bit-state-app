package com.bidstate.backend.auctionmanagement.application.buyers;

import com.bidstate.backend.auctionmanagement.domain.buyers.Buyer;
import com.bidstate.backend.auctionmanagement.domain.buyers.BuyerRepository;
import com.bidstate.backend.authmanagement.domain.UserCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Component
public class BuyerCreatedDomainEventHandler {
    private final BuyerRepository buyerRepository;

    @Transactional
    @EventListener
    public void handle(UserCreatedDomainEvent event) {
        log.info("Handling UserCreatedDomainEvent Buyer {}", event);

        if (event.roles().contains("BUYER")) {
            createBuyer(event);
        }

        log.info("Finished handling UserCreatedDomainEvent Buyer {}", event);
    }

    private void createBuyer(UserCreatedDomainEvent event) {
        log.info("Creating buyer for {}", event);

        final var buyer = Buyer.builder()
                .id(event.id())
                .name(event.name())
                .email(event.email())
                .build();

        buyerRepository.save(buyer);
    }

}
