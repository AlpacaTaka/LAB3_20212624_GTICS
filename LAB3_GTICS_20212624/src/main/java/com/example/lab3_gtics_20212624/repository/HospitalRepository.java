package com.example.lab3_gtics_20212624.repository;

import com.example.lab3_gtics_20212624.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
