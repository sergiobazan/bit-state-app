package com.bidstate.backend.authmanagement.application.users.register;

import java.util.UUID;

public record UserRegisterResponse(UUID id, String name, String email) {
}
