package com.example.crudUsuarios.DAO;

import com.example.crudUsuarios.Modelo.Alumno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class AlumnoDAOImp implements AlumnoDAO{

    //EntityManager es la clase que usamos para realizar consultas
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Alumno> listar() {
        //gestiona la bd mediante las clases java que estan mapeadas con las tabla de bd
        return entityManager.createQuery("FROM Alumno").getResultList();
    }

    @Override
    public void delete(int id) {
        Alumno alumno=entityManager.find(Alumno.class,id);
        entityManager.remove(alumno);
    }

    @Override
    public void add(Alumno alumno) {
        entityManager.merge(alumno);
    }
    public void editarAlumno(Alumno alumno){
        Alumno alumnoFind = entityManager.find(Alumno.class,alumno.getId());
        alumno.setNombre(alumno.getNombre());
        alumno.setNota(alumno.getNota());
        add(alumno);
    }
}
