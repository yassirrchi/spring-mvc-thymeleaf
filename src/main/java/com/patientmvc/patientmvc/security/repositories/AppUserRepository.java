package com.patientmvc.patientmvc.security.repositories;

import com.patientmvc.patientmvc.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
AppUser findByUsername(String username);
}
