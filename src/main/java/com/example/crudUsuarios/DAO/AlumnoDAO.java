package com.example.crudUsuarios.DAO;

import com.example.crudUsuarios.Modelo.Alumno;
import java.util.List;

public interface AlumnoDAO {

    List<Alumno> listar();
    void delete(int id);
    void add(Alumno alumno);
}
