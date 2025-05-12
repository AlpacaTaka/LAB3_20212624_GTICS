package com.example.lab3_gtics_20212624.controller;


import com.example.lab3_gtics_20212624.entity.Hospital;
import com.example.lab3_gtics_20212624.Repository.DoctorRepository;
import com.example.lab3_gtics_20212624.repository.HospitalRepository;
import com.example.lab3_gtics_20212624.Repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/hospital")
@Controller
public class HospitalController {
    final HospitalRepository hospitalRepository;
    final PacienteRepository pacienteRepository;
    final DoctorRepository doctorRepository;
    public HospitalController(HospitalRepository hospitalRepository,
                              PacienteRepository pacienteController,
                              DoctorRepository doctorController) {
        this.hospitalRepository = hospitalRepository;
        this.pacienteRepository = pacienteController;
        this.doctorRepository = doctorController;
    }


    @GetMapping(value ={"", "/listaHospitales"})
    public String listHospitals(Model model) {
        List<Hospital> hospitals = hospitalRepository.findAll();
        System.out.println("Hospitales cargados: " + hospitals.size());
        System.out.println(hospitals.get(0).getNombre());
        model.addAttribute("hospitalesList", hospitals);
        return "Hospital/listarHospitales";
    }

    @GetMapping("/{id}/doctores")
    public String mostrarDoctores(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("doctorList", doctorRepository.findByHospitalId(id));
        return "Hospital/listarDoctores";
    }

    @GetMapping("/{id}/pacientes")
    public String mostrarPacientes(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("pacienteList", pacienteRepository.findByHospitalId(id));
        return "Hospital/listarPacientes";
    }
}
