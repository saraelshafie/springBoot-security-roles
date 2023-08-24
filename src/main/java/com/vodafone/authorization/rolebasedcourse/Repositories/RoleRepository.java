package com.vodafone.authorization.rolebasedcourse.Repositories;

import com.vodafone.authorization.rolebasedcourse.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
