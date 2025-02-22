package com.bidstate.backend.propertymanagement.application.sellers;

import com.bidstate.backend.authmanagement.domain.UserUpdatedDomainEvent;
import com.bidstate.backend.propertymanagement.domain.sellers.Seller;
import com.bidstate.backend.propertymanagement.domain.sellers.SellerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Component
public class SellerUpdatedDomainEventHandler {
    private final SellerRepository sellerRepository;

    @EventListener
    @Transactional
    public void hande(UserUpdatedDomainEvent event) {
        log.info("UserUpdatedDomainEventHandler called {}", event);

        final var seller = sellerRepository.findById(event.id());

        if (seller.isEmpty()) {
            log.info("Finished UserUpdatedDomainEventHandler");
            return;
        }

        updateSeller(seller.get(), event);

        log.info("Finished UserUpdatedDomainEventHandler");
    }

    private void updateSeller(Seller seller, UserUpdatedDomainEvent event) {
        log.info("Update Seller {}", event);

        seller.update(event.name(), event.email());

        sellerRepository.save(seller);
    }

}
