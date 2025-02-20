package com.bidstate.backend.authmanagement.domain;

import java.util.UUID;

public record UserUpdatedDomainEvent(UUID id, String name, String email) {
}
