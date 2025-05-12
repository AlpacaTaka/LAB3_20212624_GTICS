package com.example.lab3_gtics_20212624.repository;

import com.example.lab3_gtics_20212624.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByHospitalId(Integer hospitalId);
}
