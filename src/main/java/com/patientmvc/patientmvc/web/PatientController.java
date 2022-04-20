package com.patientmvc.patientmvc.web;
import com.patientmvc.patientmvc.entities.Patient;
import com.patientmvc.patientmvc.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.*;
@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
   @GetMapping(path="/index")
    public String patients(Model model,
                           @RequestParam(name="page",defaultValue = "0") int page,
                           @RequestParam(name="size",defaultValue ="5" ) int size,
                           @RequestParam(name="keyword",defaultValue = "") String keyword){
       Page<Patient> patients=patientRepository.findByNomContains(keyword,PageRequest.of(page,size));
       model.addAttribute("listPatients",patients.getContent());
       model.addAttribute("pages",new int[patients.getTotalPages()]);
       model.addAttribute("currentPage",page);
       model.addAttribute("keyword",keyword);
        return "patients";
    }
    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){
       patientRepository.deleteById(id);
       return "redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/")
    public String home( ){

        return "redirect:/index";
    }
    @GetMapping("/patientsjson")
    @ResponseBody
    public List<Patient> patientList(){
       return  patientRepository.findAll();
    }
    @GetMapping("/formPatients")
    public String formPatients(Model model){
       model.addAttribute("patient",new Patient());
       return "formPatients";
    }
    @PostMapping("/save")
    public String Save(Model model, @Valid Patient patient, BindingResult bindingResult,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String keyword){
       if(bindingResult.hasErrors())
           return "formPatients";
       patientRepository.save(patient);
       return "redirect:/index?page="+page+"&keyword="+keyword;

    }
    @GetMapping("/editPatient")
    public String editPatient(Model model,Long id,String keyword,int page){
       Patient patient=patientRepository.findById(id).orElse(null);
       if(patient==null)
           throw new RuntimeException("patient introuvable");
        model.addAttribute("patient",patient);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "editPatient";
    }

}
