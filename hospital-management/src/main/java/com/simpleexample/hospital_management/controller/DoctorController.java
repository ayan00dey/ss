package com.simpleexample.hospital_management.controller;

import com.simpleexample.hospital_management.model.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/doctor/apis")

public class DoctorController {

    HashMap<Integer, Doctor>doctordb = new HashMap<>();

    @PostMapping("/save")
    public  String saveDoctor(@RequestBody Doctor inputDoctor){
        //RequestBody - takes the input or request from postman and adjust it to doctor object hole object
        doctordb.put(inputDoctor.getId(),inputDoctor);
        return "Doctor Saved Successfully";
    }

    @GetMapping("/findall")
    public HashMap<Integer, Doctor> findAllDoctors(){
        return doctordb;
    }

    @GetMapping("/find/{id}")
    public Doctor findDoctor(@PathVariable int id){
        //@PathVariable - used for single variable  input is sent in url path or endpoint
        Doctor doctor = doctordb.get(id);
        return doctor;
    }
}
