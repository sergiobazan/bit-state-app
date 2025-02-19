package com.bidstate.backend.authmanagement.application.users.register;

import java.util.List;

public record UserRegisterRequest(String name, String email, String password, List<String> roles) {
}
