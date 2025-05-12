package com.example.lab3_gtics_20212624.PacienteRepository;

import com.example.lab3_gtics_20212624.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {



}
