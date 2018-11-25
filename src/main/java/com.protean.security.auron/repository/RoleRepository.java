package com.protean.security.auron.repository;

import com.protean.security.auron.model.AppRole;
import com.protean.security.auron.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Long> {
    Optional<AppRole> findByName(RoleName roleName);
}
