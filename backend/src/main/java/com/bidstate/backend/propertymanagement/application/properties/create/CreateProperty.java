package com.bidstate.backend.propertymanagement.application.properties.create;

import com.bidstate.backend.propertymanagement.application.properties.PropertyMapper;
import com.bidstate.backend.propertymanagement.domain.properties.Address;
import com.bidstate.backend.propertymanagement.domain.properties.CategoryRepository;
import com.bidstate.backend.propertymanagement.domain.properties.Property;
import com.bidstate.backend.propertymanagement.domain.properties.PropertyRepository;
import com.bidstate.backend.propertymanagement.domain.sellers.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class CreateProperty {
    private final PropertyRepository propertyRepository;
    private final CategoryRepository categoryRepository;
    private final SellerRepository sellerRepository;

    @Transactional
    public CreatePropertyResponse create(final CreatePropertyRequest request) throws Exception {
        final var category = categoryRepository.findById(request.categoryId());

        if (category.isEmpty()) {
            throw new Exception("Not found category");
        }

        final var seller = sellerRepository.findById(request.sellerId());

        if (seller.isEmpty()) {
            throw new Exception("Not found seller");
        }

        final var property = Property.builder()
                .title(request.title())
                .description(request.description())
                .price(request.price())
                .status(request.status())
                .type(request.type())
                .address(new Address(
                        request.street(),
                        request.city(),
                        request.state()
                ))
                .measures(request.measures())
                .category(category.get())
                .seller(seller.get())
                .build();

        final var savedProperty = propertyRepository.save(property);

        return PropertyMapper.fromEntity(savedProperty);
    }
}
