package com.bidstate.backend.auctionmanagement.application.buyers;

import com.bidstate.backend.auctionmanagement.domain.buyers.Buyer;
import com.bidstate.backend.auctionmanagement.domain.buyers.BuyerRepository;
import com.bidstate.backend.authmanagement.domain.UserUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Component
public class BuyerUpdatedDomainEventHandler {
    private final BuyerRepository buyerRepository;

    @Transactional
    @EventListener
    public void handle(UserUpdatedDomainEvent event) {
        log.info("Handling UserUpdatedDomainEvent Buyer {}", event);

        final var buyer = buyerRepository.findById(event.id());

        if (buyer.isEmpty()) {
            log.info("Finished UserUpdatedDomainEvent");
            return;
        }

        updateBuyer(buyer.get(), event);

        log.info("Finished handling UserUpdatedDomainEvent Buyer {}", event);
    }

    private void updateBuyer(Buyer buyer, UserUpdatedDomainEvent event) {
        log.info("Updating buyer for {}", event);

        buyer.update(event.name(), event.email());

        buyerRepository.save(buyer);
    }

}
