package com.example.crudUsuarios.DAO;

import com.example.crudUsuarios.Modelo.Usuario;

public interface UsuarioDAO {

    /* para el signup hay que hacer insert en la tabla usuarios verificando que no exista ese nombre de usuario*/
    /*para el login hay que verificar que exista ese usuario y que su contraseña esté bien*/
    boolean existeUsuario(String nombre);
    void add(Usuario usuario);
    boolean usuarioCorrecto(String nombre, String password);
}