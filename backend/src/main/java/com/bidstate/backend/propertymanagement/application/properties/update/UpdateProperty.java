package com.bidstate.backend.propertymanagement.application.properties.update;

import com.bidstate.backend.propertymanagement.domain.properties.Address;
import com.bidstate.backend.propertymanagement.domain.properties.CategoryRepository;
import com.bidstate.backend.propertymanagement.domain.properties.PropertyRepository;
import com.bidstate.backend.propertymanagement.domain.sellers.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UpdateProperty {
    private final PropertyRepository propertyRepository;
    private final CategoryRepository categoryRepository;
    private final SellerRepository sellerRepository;

    @Transactional
    public void updateProperty(UUID id, UpdatePropertyRequest propertyRequest) throws Exception {
        final var propertyFound = propertyRepository.findById(id);

        if (propertyFound.isEmpty()) {
            throw new Exception("No Property found");
        }

        final var category = categoryRepository.findById(propertyRequest.categoryId());

        if (category.isEmpty()) {
            throw new Exception("No Category found");
        }

        final var seller = sellerRepository.findById(propertyRequest.sellerId());

        if (seller.isEmpty()) {
            throw new Exception("No Seller found");
        }

        propertyFound.get().update(
                propertyRequest.title(),
                propertyRequest.description(),
                propertyRequest.price(),
                propertyRequest.measures(),
                propertyRequest.type(),
                propertyRequest.status(),
                new Address(
                        propertyRequest.street(),
                        propertyRequest.city(),
                        propertyRequest.state()
                ),
                category.get(),
                seller.get()
        );

        propertyRepository.save(propertyFound.get());
    }
}
