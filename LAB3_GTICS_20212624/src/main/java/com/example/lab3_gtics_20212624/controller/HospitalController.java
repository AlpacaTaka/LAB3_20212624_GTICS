package com.example.lab3_gtics_20212624.controller;


import com.example.lab3_gtics_20212624.entity.Hospital;
import com.example.lab3_gtics_20212624.repository.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HospitalController {
    final HospitalRepository hospitalRepository;
    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping(value = "hospitales")
    public String listHospitals(Model model) {
        List<Hospital> hospitals = hospitalRepository.findAll();
        model.addAttribute("hospitalesList", hospitals);
        return "listarHospitales";
    }
}
