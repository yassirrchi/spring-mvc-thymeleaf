package com.patientmvc.patientmvc.security.repositories;

import com.patientmvc.patientmvc.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
AppRole findByRoleName(String roleName);
}
