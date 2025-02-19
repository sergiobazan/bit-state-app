package com.bidstate.backend.authmanagement.application.users;

import com.bidstate.backend.authmanagement.application.users.register.UserRegisterResponse;
import com.bidstate.backend.authmanagement.domain.User;

public class UserMapper {
    public static UserRegisterResponse fromEntity(User user) {
        return new UserRegisterResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
