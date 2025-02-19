package com.bidstate.backend.authmanagement.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    List<Role> findRolesByNameIn(List<String> names);
}
