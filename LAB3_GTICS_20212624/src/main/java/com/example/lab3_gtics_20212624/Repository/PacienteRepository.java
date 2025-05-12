package com.example.lab3_gtics_20212624.Repository;

import com.example.lab3_gtics_20212624.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {



    @Query("SELECT p FROM Paciente p WHERE p.doctor.id = :doctorId")
    List<Paciente> listarProximasCitas(@Param("doctorId") Integer doctorId);
}
