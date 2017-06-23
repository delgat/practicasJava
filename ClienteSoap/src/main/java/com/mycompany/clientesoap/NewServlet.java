/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientesoap;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.ServicioUsuarios;
import ws.ServicioUsuarios_Service;
import ws.Usuario;

/**
 *
 * @author jdcaparros
 */
public class NewServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/proyectoFinal/ServicioUsuarios.wsdl")
    private ServicioUsuarios_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        String registrar = request.getParameter("registrar");
        String login = request.getParameter("login");
        if (login != null) {
            try { // Call Web Service Operation
                ServicioUsuarios port = service.getServicioUsuariosPort();

                Usuario result = port.existeUsuario(user, pass);
                ServletContext sc = getServletContext();
                System.out.println("Result = " + result);
                if (result.getId() == 0L) {
                    RequestDispatcher rd = sc.getRequestDispatcher("/error.html");
                    rd.forward(request, response);

                } else {
                    request.setAttribute("user", result);
                    getServletContext().getRequestDispatcher("/logeado.jsp").forward(request, response);
                }

            } catch (Exception ex) {
                System.out.println(ex);

            }
        } else {
            try { // Call Web Service Operation
                ServicioUsuarios port = service.getServicioUsuariosPort();

                Usuario result = port.existeUsuario(user, pass);
                ServletContext sc = getServletContext();
                System.out.println("Result = " + result);
                if (result.getId() == 0L) {
                      Usuario result2 = port.crearUser(user, pass);
                    request.setAttribute("user", result2);
                    getServletContext().getRequestDispatcher("/logeado.jsp").forward(request, response);
                } else {
                    RequestDispatcher rd = sc.getRequestDispatcher("/error.html");
                    rd.forward(request, response);

                }

            } catch (Exception ex) {

            }
        }

//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NewServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
