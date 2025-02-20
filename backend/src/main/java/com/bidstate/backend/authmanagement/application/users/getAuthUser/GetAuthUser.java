package com.bidstate.backend.authmanagement.application.users.getAuthUser;

import com.bidstate.backend.authmanagement.application.users.UserMapper;
import com.bidstate.backend.authmanagement.application.users.register.UserRegisterResponse;
import com.bidstate.backend.authmanagement.domain.UserRepository;
import com.bidstate.backend.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class GetAuthUser {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Transactional(readOnly = true)
    public UserRegisterResponse getAuthUser(String token) throws Exception {
        final var email = jwtService.getUserEmailFromToken(token);
        final var user = userRepository.findByEmail(email);

        if (user == null) {
            throw new Exception("No User found");
        }

        return UserMapper.fromEntity(user);
    }
}
