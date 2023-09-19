package com.example.crudUsuarios.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Table(name = "usuarios")
@ToString
@EqualsAndHashCode
@Entity

public class Usuario {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name="password")
    private String password;
    @Column(name="admin")
    private int admin;
}