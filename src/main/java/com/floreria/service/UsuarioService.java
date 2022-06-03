/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */



/** ******************************************************************************
 *    Autor:Floriceli Gonzalez Ruiz                                         *
 *    Fecha creación: 30 de abril del 2022.                                     *
 *    Fecha actualización: 1 de mayo del 2022.                                *
 *    Descripción: UsuarioService                            *
 ******************************************************************************* */


package com.floreria.service;


import com.floreria.entity.Usuario;
import java.util.List;

/**
 *
 * @author labso09
 */
public interface UsuarioService {
  public List<Usuario> obtenerRegistros();
   
   public void actualizarRegistro(Usuario usuario);
   
   public void eliminarRegistro(Usuario usuario);
   
   public void crearRegistro(Usuario usuario);
    
   public Usuario obtenerRegistro (int idUsuario);  
}
