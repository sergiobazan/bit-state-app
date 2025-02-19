package com.bidstate.backend.authmanagement.presentation;

import com.bidstate.backend.authmanagement.application.users.register.RegisterUser;
import com.bidstate.backend.authmanagement.application.users.register.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final RegisterUser registerUser;

    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody final UserRegisterRequest userRegisterRequest) {
        try {
            var result = registerUser.register(userRegisterRequest);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
