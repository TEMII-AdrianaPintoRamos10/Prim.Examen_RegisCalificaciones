/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/calificaciones")
public class calificaciones extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<calificacion> calificaciones = (ArrayList<calificacion>) session.getAttribute("calificaciones");

        if (calificaciones == null) {
            calificaciones = new ArrayList<>();
            session.setAttribute("calificaciones", calificaciones);
        }

        request.getRequestDispatcher("calificaciones.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<calificacion> calificaciones = (ArrayList<calificacion>) session.getAttribute("calificaciones");

        if (calificaciones == null) {
            calificaciones = new ArrayList<>();
            session.setAttribute("calificaciones", calificaciones);
        }

        String action = request.getParameter("action");

        if (action.equals("add")) {
            String nombre = request.getParameter("nombre");
            int primerParcial = Integer.parseInt(request.getParameter("primerParcial"));
            int segundoParcial = Integer.parseInt(request.getParameter("segundoParcial"));
            int examenFinal = Integer.parseInt(request.getParameter("examenFinal"));

            calificacion calificacion = new calificacion(nombre, primerParcial, segundoParcial, examenFinal);
            calificaciones.add(calificacion);
        } else if (action.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            calificacion calificacion = calificaciones.get(id - 1);
            calificacion.setNombre(request.getParameter("nombre"));
            calificacion.setPrimerParcial(Integer.parseInt(request.getParameter("primerParcial")));
            calificacion.setSegundoParcial(Integer.parseInt(request.getParameter("segundoParcial")));
            calificacion.setExamenFinal(Integer.parseInt(request.getParameter("examenFinal")));
            calificacion.setNotaFinal(calificacion.calcularNotaFinal());
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            calificaciones.remove(id - 1);
        }

        response.sendRedirect(request.getContextPath() + "/calificaciones");
    }
}
