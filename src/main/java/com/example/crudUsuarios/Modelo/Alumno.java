package com.example.crudUsuarios.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Table(name = "alumno")
@ToString
@EqualsAndHashCode
@Entity

public class Alumno {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nota")
    private int nota;
}