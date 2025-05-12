package com.example.lab3_gtics_20212624.Repository;

import com.example.lab3_gtics_20212624.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {



    @Query("SELECT d FROM Doctor d JOIN FETCH d.hospital")
    List<Doctor> obtenerDoctoresConHospital();
}