package com.patientmvc.patientmvc.security.service;

import com.patientmvc.patientmvc.security.entities.AppRole;
import com.patientmvc.patientmvc.security.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUserName(String username);

}
