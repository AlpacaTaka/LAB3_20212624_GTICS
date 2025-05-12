package com.example.lab3_gtics_20212624.controller;

import com.example.lab3_gtics_20212624.Repository.DoctorRepository;
import com.example.lab3_gtics_20212624.Repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctores")
public class DoctorController {

    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;

    public DoctorController(DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping(value = {"","listarDoctores"})
    public String listarDoctores(Model model) {
        model.addAttribute("doctorList", doctorRepository.obtenerDoctoresConHospital());
        return "Doctores/listarDoctores";

    }



    @GetMapping("/{id}/pacientesAtendidos")
    public String listarCitas(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("pacientes", pacienteRepository.listarProximasCitas(id));
        return "Doctores/listarPacientesAtendidos";
    }


}
