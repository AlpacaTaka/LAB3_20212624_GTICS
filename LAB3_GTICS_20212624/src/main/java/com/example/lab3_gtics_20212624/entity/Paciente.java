package com.example.lab3_gtics_20212624.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String nombre;
    private int edad;
    private String genero;
    private String diagnostico;

    @Column(name = "fecha_cita")
    private LocalDate fechaCita;

    @Column(name = "numero_habitacion")
    private int numeroHabitacion;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

}
