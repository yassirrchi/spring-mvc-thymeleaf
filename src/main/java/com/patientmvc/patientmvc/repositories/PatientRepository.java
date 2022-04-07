package com.patientmvc.patientmvc.repositories;

import com.patientmvc.patientmvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
Page<Patient> findByNomContains(String keyw, Pageable pageable);
}
