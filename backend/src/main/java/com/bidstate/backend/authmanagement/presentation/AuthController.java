package com.bidstate.backend.authmanagement.presentation;

import com.bidstate.backend.authmanagement.application.users.getAuthUser.GetAuthUser;
import com.bidstate.backend.authmanagement.application.users.login.LoginRequest;
import com.bidstate.backend.authmanagement.application.users.login.LoginUser;
import com.bidstate.backend.authmanagement.application.users.register.RegisterUser;
import com.bidstate.backend.authmanagement.application.users.register.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final RegisterUser registerUser;
    private final LoginUser loginUser;
    private final GetAuthUser getAuthUser;

    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody final UserRegisterRequest userRegisterRequest) {
        try {
            var result = registerUser.register(userRegisterRequest);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody final LoginRequest loginRequest) {
        try {
            var result = loginUser.login(loginRequest);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/me")
    ResponseEntity<?> me(@RequestHeader("Authorization") String token) {
        token = token.substring(7);
        try {
            var result = getAuthUser.getAuthUser(token);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
