package com.zulmaidi.authservice.repository;

import com.zulmaidi.authservice.model.ERole;
import com.zulmaidi.authservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
