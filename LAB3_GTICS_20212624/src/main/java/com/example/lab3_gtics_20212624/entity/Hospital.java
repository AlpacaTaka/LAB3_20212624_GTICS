package com.example.lab3_gtics_20212624.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
//Loombok no esta funcionando :c
@Table(name = "hospital")
public class Hospital {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String nombre;
    private String direccion;
    private String telefono;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
