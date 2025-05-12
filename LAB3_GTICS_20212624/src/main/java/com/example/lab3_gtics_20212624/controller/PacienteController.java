package com.example.lab3_gtics_20212624.controller;

import com.example.lab3_gtics_20212624.PacienteRepository.DoctorRepository;
import com.example.lab3_gtics_20212624.PacienteRepository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = {"/paciente"})
public class PacienteController {

    private final PacienteRepository pacienteRepository;
    private final DoctorRepository doctorRepository;

    public PacienteController(PacienteRepository pacienteRepository, DoctorRepository doctorRepository) {
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping(value = {"/listarPacientes","","/"})
    public String listarPacientes(Model model) {
        model.addAttribute("pacienteList", pacienteRepository.obtenerPacientesConHospitalYDoctor());
        return "Paciente/listarPacientes";
    }


    @GetMapping("/derivar")
    public String mostrarFormularioDerivacion(Model model) {
        model.addAttribute("doctorList", doctorRepository.findAll());
        return "Paciente/derivarPacientes";
    }


    @PostMapping("/derivar/guardar")
    public String derivarPacientes(@RequestParam("origen") Integer origenId,
                                   @RequestParam("destino") Integer destinoId) {

        pacienteRepository.derivarPacientesEntreDoctores(origenId, destinoId);

        return "redirect:/paciente";
    }
}
