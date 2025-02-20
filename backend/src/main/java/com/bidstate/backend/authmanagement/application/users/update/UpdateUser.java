package com.bidstate.backend.authmanagement.application.users.update;

import com.bidstate.backend.authmanagement.domain.UserRepository;
import com.bidstate.backend.authmanagement.domain.UserUpdatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UpdateUser {
    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;

    @Transactional
    public void updateUser(UUID id, final UpdateUserRequest user) throws Exception {
        final var foundUser = userRepository.findById(id)
                .orElseThrow(() -> new Exception("No User found"));

        foundUser.update(user.name(), user.email());

        publisher.publishEvent(new UserUpdatedDomainEvent(
                foundUser.getId(),
                foundUser.getName(),
                foundUser.getEmail()
        ));

        userRepository.save(foundUser);
    }
}
