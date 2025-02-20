package com.bidstate.backend.authmanagement.application.users.login;

import com.bidstate.backend.authmanagement.domain.UserRepository;
import com.bidstate.backend.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LoginUser {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder encoder;

    public LoginResponse login(LoginRequest loginRequest) throws Exception {
        final var user = userRepository.findByEmail(loginRequest.email());

        if (user == null) {
            throw new Exception("Authentication failed");
        }

        if (!encoder.matches(loginRequest.password(), user.getPassword())) {
            throw new Exception("Authentication failed");
        }

        String token = jwtService.generateToken(user);

        return new LoginResponse(token);
    }
}
