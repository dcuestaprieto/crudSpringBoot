package com.example.crudUsuarios.Controller;

import com.example.crudUsuarios.DAO.AlumnoDAO;
import com.example.crudUsuarios.DAO.AlumnoDAOImp;
import com.example.crudUsuarios.DAO.UsuarioDAO;
import com.example.crudUsuarios.DAO.UsuarioDAOImp;
import com.example.crudUsuarios.Modelo.Alumno;
import com.example.crudUsuarios.Modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    AlumnoDAOImp alumnoDAO;
    @Autowired
    UsuarioDAOImp usuarioDAO;

    @GetMapping("/listarAlumnos")
    public List<Alumno> listar(){
        return alumnoDAO.listar();
    }

    @PostMapping("/addUsuario")
    //Pido un json con los datos de usuario el cual se debe pasar por parámetro
    public void addUsuario(@RequestBody Usuario usuario){
        usuarioDAO.add(usuario);
    }
    @PutMapping("/editarAlumno/")
    public void editarAlumno(@RequestBody Alumno alumno){
        alumnoDAO.editarAlumno(alumno);
    }



    @DeleteMapping("/eliminarAlumno/{id}")
    public void delete(@PathVariable int id){
        alumnoDAO.delete(id);
    }
    @PostMapping("/addAlumno")
    public void addAlumno(@RequestBody Alumno alumno){
        alumnoDAO.add(alumno);
    }
}
