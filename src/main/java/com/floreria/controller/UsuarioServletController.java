/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */



/** ******************************************************************************
 *    Autor:Floriceli Gonzalez Ruiz                                         *
 *    Fecha creación: 30 de abril del 2022.                                     *
 *    Fecha actualización: 1 de mayo del 2022.                                *
 *    Descripción: UsuarioServletController                            *
 ******************************************************************************* */




package com.floreria.controller;

import com.floreria.entity.Usuario;
import com.floreria.service.UsuarioService;
import com.floreria.service.UsuarioServiceImpl;
import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author labso09
 */
public class UsuarioServletController extends HttpServlet {
UsuarioService service;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Action:" + action);
       switch (action) {
            case "listar":
                System.out.println("Listando...");
                Listar(request, response);
                break;
            case "crear":
                System.out.println("Creando...");
                crear(request, response);
                break;
            case "crearForm":
                System.out.println("Creando...");
                crearFormulario(request, response);
                break;
            case "crearBD":
                crear(request, response);
                break;
            case "list":
                System.out.println("Creando...");
                Listar(request, response);
                break;
            case "galeria":
                System.out.println("Mostrando...");
                fotosGaleria(request, response);
                break;
            case "actualizar":
                System.out.println("Creando...");
                actualizar(request, response);
                break;
            case "actualizarForm":
                System.out.println("Creando...");
                actualizarForm(request, response);
                break;
            case "eliminar":
                System.out.println("Creando...");
                Eliminar(request, response);
                break;

        }
    }

   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println("");
        doGet(request, response);
    }
    

    
    private void Listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("pages/list.jsp");
        this.service = new UsuarioServiceImpl();
        List<Usuario> ListaUsuario = this.service.obtenerRegistros();
        request.setAttribute("ListaUsuario", ListaUsuario);
        dispatcher.forward(request, response);
    }
    
    private void crearFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("pages/createForm.jsp");
        dispatcher.forward(request, response);

    }
    
    
    private void actualizarForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher dispatcher = request.getRequestDispatcher("pages/actualizarForm.jsp");
        Usuario usuario = this.service.obtenerRegistro(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("usuario", usuario);
       
        dispatcher.forward(request, response);

    } 
    
     private void fotosGaleria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("pages/galeria.jsp");
        dispatcher.forward(request, response);

    }

    private void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setNombreusuario(request.getParameter("nombreusuario"));
        usuario.setContrasena(request.getParameter("contrasena"));
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setSexo(request.getParameter("sexo"));
        usuario.setEdad(Integer.parseInt(request.getParameter("edad")));
        service = new UsuarioServiceImpl();
        service.crearRegistro(usuario);
        System.out.println("INGRESADO: " + usuario.getNombre());

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("UsuarioServletController?action=listar");
        dispatcher.forward(request, response);
       this.service = new UsuarioServiceImpl();
        List<Usuario> ListaUsuario = this.service.obtenerRegistros();
        request.setAttribute("ListaUsuario", ListaUsuario);
        dispatcher.forward(request, response);
    }
    
     private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println(request.getParameter("id"));
        Usuario usuario = new Usuario(Integer.parseInt(request.getParameter("id")));
        usuario.setNombreusuario(request.getParameter("nombreusuario"));
        usuario.setContrasena(request.getParameter("contrasena"));
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setSexo(request.getParameter("sexo"));
        usuario.setEdad(Integer.parseInt(request.getParameter("edad")));
        service = new UsuarioServiceImpl();
        service.actualizarRegistro(usuario);
        System.out.println("INGRESADO: " + usuario.getNombre());

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("UsuarioServletController?action=listar");
        dispatcher.forward(request, response);
       this.service = new UsuarioServiceImpl();
        List<Usuario> ListaUsuario = this.service.obtenerRegistros();
        request.setAttribute("ListaUsuario", ListaUsuario);
        dispatcher.forward(request, response);
    }

    
    
    
    private void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       RequestDispatcher dispatcher
                = request.getRequestDispatcher("pages/list.jsp");
      this.service = new UsuarioServiceImpl();
      Usuario usuario = new Usuario();
      usuario = this.service.obtenerRegistro(Integer.parseInt(request.getParameter("id")));
      service.eliminarRegistro(usuario);
      System.out.println("eliminando");
      List<Usuario> ListaUsuario = this.service.obtenerRegistros();
      request.setAttribute("ListaUsuario", ListaUsuario);
      dispatcher.forward(request, response);
    }
    
   
}
