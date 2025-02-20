package com.bidstate.backend.propertymanagement.presentation;

import com.bidstate.backend.propertymanagement.application.properties.create.CreateProperty;
import com.bidstate.backend.propertymanagement.application.properties.create.CreatePropertyRequest;
import com.bidstate.backend.propertymanagement.application.properties.getAll.GetAllProperties;
import com.bidstate.backend.propertymanagement.application.properties.getById.GetPropertyById;
import com.bidstate.backend.propertymanagement.application.properties.update.UpdateProperty;
import com.bidstate.backend.propertymanagement.application.properties.update.UpdatePropertyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/properties")
public class PropertyController {
    private final CreateProperty createProperty;
    private final GetAllProperties getAllProperties;
    private final GetPropertyById getPropertyById;
    private final UpdateProperty updateProperty;

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

    @GetMapping("{id}")
    ResponseEntity<?> getByPropertyId(@PathVariable final UUID id) {
        try {
            final var result = getPropertyById.getPropertyById(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    ResponseEntity<?> updateProperty(
            @PathVariable final UUID id,
            @RequestBody final UpdatePropertyRequest propertyRequest) {
        try {
            updateProperty.updateProperty(id, propertyRequest);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
