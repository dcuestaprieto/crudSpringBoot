package com.example.crudUsuarios.DAO;

import com.example.crudUsuarios.Modelo.Alumno;
import com.example.crudUsuarios.Modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class UsuarioDAOImp implements UsuarioDAO{

    //EntityManager es la clase que usamos para realizar consultas
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean existeUsuario(String nombre) {
        boolean usuarioExiste;
        if (entityManager.find(Usuario.class, nombre) == null){
            usuarioExiste=false;
            entityManager.find(Usuario.class,nombre);
        }else {
            usuarioExiste=true;
        }
        return usuarioExiste;
    }
    @Override
    public void add(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean usuarioCorrecto(String nombre, String password) {
        return false;
    }
}
