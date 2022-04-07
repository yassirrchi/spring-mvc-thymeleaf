package com.patientmvc.patientmvc;

import com.patientmvc.patientmvc.entities.Patient;
import com.patientmvc.patientmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return  args ->{
         //   patientRepository.save(new Patient(null,"hamid",new Date(),false,12));
           // patientRepository.save(new Patient(null,"hasbulla",new Date(),true,142));
            patientRepository.save(new Patient(null,"yassir",new Date(),false,12));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });


        };
    }
}
