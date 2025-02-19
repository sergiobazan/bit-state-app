package com.bidstate.backend.propertymanagement.application.sellers;

import com.bidstate.backend.authmanagement.domain.UserCreatedDomainEvent;
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
public class UserCreateDomainEventHandler {
    private final SellerRepository sellerRepository;

    @EventListener
    @Transactional
    public void hande(UserCreatedDomainEvent event) {
        log.info("UserCreateDomainEventHandler called {}", event);

        if (event.roles().contains("SELLER")) {
            createSeller(event);
        }

        log.info("Finished UserCreateDomainEventHandler");
    }

    private void createSeller(UserCreatedDomainEvent event) {
        log.info("Create Seller {}", event);

        final var seller = Seller.builder()
                .id(event.id())
                .name(event.name())
                .email(event.email())
                .build();

        sellerRepository.save(seller);
    }

}
