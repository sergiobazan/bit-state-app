package com.bidstate.backend.authmanagement.application.users.register;

import com.bidstate.backend.authmanagement.application.users.UserMapper;
import com.bidstate.backend.authmanagement.domain.Role;
import com.bidstate.backend.authmanagement.domain.RoleRepository;
import com.bidstate.backend.authmanagement.domain.User;
import com.bidstate.backend.authmanagement.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Transactional
public class RegisterUser {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;
    private final ApplicationEventPublisher eventPublisher;

    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) throws Exception {
        final var roles = roleRepository.findRolesByNameIn(userRegisterRequest.roles());

        if (roles.isEmpty()) {
            throw new Exception("No roles found");
        }

        final var user = User.builder()
                .name(userRegisterRequest.name())
                .email(userRegisterRequest.email())
                .password(encoder.encode(userRegisterRequest.password()))
                .roles(new HashSet<>(roles))
                .build();

        final var userSaved = userRepository.save(user);

        // publish domain event to save Seller or Buyer in others Bounded Context
        eventPublisher.publishEvent(new UserCreatedDomainEvent(
                userSaved.getId(),
                userSaved.getName(),
                userSaved.getEmail(),
                roles.stream().map(Role::getAuthority).collect(Collectors.toList())
        ));

        return UserMapper.fromEntity(userSaved);
    }
}
