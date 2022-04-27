package com.patientmvc.patientmvc.security.entities;

import com.patientmvc.patientmvc.security.entities.AppRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class AppUser {
    @Id
    private String userId;
    @Column(unique = true)
    private String username;
    private String password;
    private boolean active;
    @ManyToMany(fetch= FetchType.EAGER)
    private List<AppRole> appRoles=new ArrayList<>();
}
