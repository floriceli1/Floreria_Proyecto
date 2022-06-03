/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/** ******************************************************************************
 *    Autor:Floriceli Gonzalez Ruiz                                         *
 *    Fecha creación: 30 de abril del 2022.                                     *
 *    Fecha actualización: 1 de mayo del 2022.                                *
 *    Descripción: UsuarioServiceImpl                           *
 ******************************************************************************* */



package com.floreria.service;


import com.floreria.entity.Usuario;
import com.floreria.model.UsuarioModel;
import com.floreria.model.UsuarioModelImpl;
import java.util.List;

/**
 *
 * @author labso09
 */
public class UsuarioServiceImpl implements UsuarioService{
    UsuarioModel model =new UsuarioModelImpl();
    
    @Override
    public List<Usuario> obtenerRegistros() {
        return model.obtenerRegistros();
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
       model.actualizarRegistro(usuario);
    }

    @Override
    public void eliminarRegistro(Usuario usuario) {
       model.eliminarRegistro(usuario);
    }

    @Override
    public void crearRegistro(Usuario usuario) {
        model.crearRegistro(usuario);
    }

    @Override
    public Usuario obtenerRegistro(int idUsuario) {
     return model.obtenerRegistro(idUsuario);
    }
    
}
