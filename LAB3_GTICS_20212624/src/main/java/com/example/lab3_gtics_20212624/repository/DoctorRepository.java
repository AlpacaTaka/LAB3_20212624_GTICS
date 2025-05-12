package com.example.lab3_gtics_20212624.repository;

import com.example.lab3_gtics_20212624.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findByHospitalId(Integer hospitalId);
}
