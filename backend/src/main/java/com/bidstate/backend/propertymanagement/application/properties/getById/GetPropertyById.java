package com.bidstate.backend.propertymanagement.application.properties.getById;

import com.bidstate.backend.propertymanagement.application.properties.PropertyMapper;
import com.bidstate.backend.propertymanagement.application.properties.create.CreatePropertyResponse;
import com.bidstate.backend.propertymanagement.domain.properties.Property;
import com.bidstate.backend.propertymanagement.domain.properties.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class GetPropertyById {
    private final PropertyRepository propertyRepository;

    @Transactional(readOnly = true)
    public CreatePropertyResponse getPropertyById(UUID id) throws Exception {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new Exception("No Property found"));
        return PropertyMapper.fromEntity(property);
    }
}
