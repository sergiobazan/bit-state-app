package com.bidstate.backend.authmanagement.domain;

import java.util.List;
import java.util.UUID;

public record UserCreatedDomainEvent(UUID id, String name, String email, List<String> roles) {
}
