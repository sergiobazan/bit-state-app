package com.bidstate.backend.propertymanagement.presentation;

import com.bidstate.backend.propertymanagement.application.property.create.CreateProperty;
import com.bidstate.backend.propertymanagement.application.property.create.CreatePropertyRequest;
import com.bidstate.backend.propertymanagement.application.property.getAll.GetAllProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/properties")
public class PropertyController {
    private final CreateProperty createProperty;
    private final GetAllProperties getAllProperties;

    @PostMapping
    ResponseEntity<?> createProperty(@RequestBody final CreatePropertyRequest propertyRequest) {
        try {
            final var result = createProperty.create(propertyRequest);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    ResponseEntity<?> getAllProperties() {
        try {
            final var result = getAllProperties.getAll();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
