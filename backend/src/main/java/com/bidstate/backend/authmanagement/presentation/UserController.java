package com.bidstate.backend.authmanagement.presentation;

import com.bidstate.backend.authmanagement.application.users.update.UpdateUser;
import com.bidstate.backend.authmanagement.application.users.update.UpdateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UpdateUser updateUser;

    @PutMapping("{id}")
    ResponseEntity<?> updateUser(
            @PathVariable final UUID id,
            @RequestBody final UpdateUserRequest user) {
        try {
            updateUser.updateUser(id, user);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
