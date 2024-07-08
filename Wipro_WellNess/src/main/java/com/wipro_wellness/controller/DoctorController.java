package com.wipro_wellness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro_wellness.Entity.Doctor;
import com.wipro_wellness.Entity.Patient;
import com.wipro_wellness.dto.DoctorDto;
import com.wipro_wellness.service.DoctorService;
import com.wipro_wellness.service.DoctorServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
   @Autowired
	private DoctorServiceImp doctorServiceImp;
   
   
   @PostMapping("/addDoctor")
   @PreAuthorize("hasRole('ADMIN')")
   public DoctorDto addDoctorDetails(@Valid @RequestBody DoctorDto doctor)
   {
	   return doctorServiceImp.addDetails(doctor);
   }
   @PutMapping("/update")
   @PreAuthorize("hasRole('ADMIN')")
   public DoctorDto update(@Valid @RequestBody DoctorDto doctor)
   {
	   return doctorServiceImp.update(doctor);
   }
   
   @GetMapping("/getAllDoctors")
   public List<DoctorDto> getAllDoctor()
   {
	  return doctorServiceImp.getAllDoctorDetails();
   }
  
   
}
