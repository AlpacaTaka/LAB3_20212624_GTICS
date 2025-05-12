package com.example.lab3_gtics_20212624.Repository;

import com.example.lab3_gtics_20212624.entity.Paciente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {



    List<Paciente> findByHospitalId(Integer hospitalId);


    @Query("SELECT p FROM Paciente p WHERE p.doctor.id = :doctorId")
    List<Paciente> listarProximasCitas(@Param("doctorId") Integer doctorId);


    @Query("SELECT p FROM Paciente p JOIN FETCH p.hospital JOIN FETCH p.doctor")
    List<Paciente> obtenerPacientesConHospitalYDoctor();


    @Modifying
    @Transactional
    @Query("UPDATE Paciente p SET p.doctor.id = :destinoId WHERE p.doctor.id = :origenId")
    void derivarPacientesEntreDoctores(@Param("origenId") Integer origenId,
                                       @Param("destinoId") Integer destinoId);



    //corecciones

}
