package com.patientmvc.patientmvc;

import com.patientmvc.patientmvc.entities.Patient;
import com.patientmvc.patientmvc.repositories.PatientRepository;
import com.patientmvc.patientmvc.security.service.SecurityService;
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
  //  @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return  args ->{
         //   patientRepository.save(new Patient(null,"hamid",new Date(),false,12));
           // patientRepository.save(new Patient(null,"hasbulla",new Date(),true,142));
           // patientRepository.save(new Patient(null,"yassir",new Date(),false,12));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });


        };
    }
    @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {

/*

            securityService.saveNewUser("yassirrchi","1234","1234");
            securityService.addRoleToUser("yassirrchi","USER");
            securityService.addRoleToUser("yassirrchi","ADMIN");
     securityService.saveNewUser("anwar","1234","1234");
            securityService.saveNewUser("zakaria","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("anwar","USER");
            securityService.addRoleToUser("zakaria","ADMIN");*/
        };
    }
}
