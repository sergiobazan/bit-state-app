package com.bidstate.backend.propertymanagement.application.property.getAll;

import com.bidstate.backend.propertymanagement.application.property.create.CreatePropertyResponse;
import com.bidstate.backend.propertymanagement.application.property.PropertyMapper;
import com.bidstate.backend.propertymanagement.domain.properties.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllProperties {
    private final PropertyRepository propertyRepository;

    @Transactional(readOnly = true)
    public List<CreatePropertyResponse> getAll() {
        return propertyRepository.findAll()
                .stream()
                .map(PropertyMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
