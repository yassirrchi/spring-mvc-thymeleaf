package com.patientmvc.patientmvc.security.service;

import com.patientmvc.patientmvc.security.entities.AppRole;
import com.patientmvc.patientmvc.security.entities.AppUser;
import com.patientmvc.patientmvc.security.repositories.AppRoleRepository;
import com.patientmvc.patientmvc.security.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl implements SecurityService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;



    @Override
    public AppUser saveNewUser(String username, String password, String rePassword) {
        if(!password.equals((rePassword))) throw new RuntimeException("passwords not match");
       String hashedPWD=passwordEncoder.encode(password);
       AppUser appUser=new AppUser();
       appUser.setUserId(UUID.randomUUID().toString());
       appUser.setUsername(username);
        appUser.setPassword(hashedPWD);
        appUser.setActive(true);
        appUserRepository.save(appUser);


        return appUser;
    }

    @Override
    public AppRole saveNewRole(String roleName, String description) {
        AppRole appRole= appRoleRepository.findByRoleName(roleName);
        if(appRole!=null) throw new RuntimeException(" role "+roleName+" already exist");
        appRole=new AppRole();
        appRole.setRoleName(roleName);
        appRole.setDescription(description);
       AppRole savedApprole= appRoleRepository.save(appRole);


        return savedApprole;
    }


    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser= appUserRepository.findByUsername(username);
        if(appUser==null) throw new RuntimeException(" User not found ");

        AppRole appRole= appRoleRepository.findByRoleName(roleName);
        if(appRole==null) throw new RuntimeException(" role not fond");

        appUser.getAppRoles().add(appRole);

    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {

        AppUser appUser= appUserRepository.findByUsername(username);
        if(appUser==null) throw new RuntimeException(" User not found ");

        AppRole appRole= appRoleRepository.findByRoleName(roleName);
        if(appRole==null) throw new RuntimeException(" role not fond");

        appUser.getAppRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUserName(String username) {
        return appUserRepository.findByUsername(username);
    }
}
