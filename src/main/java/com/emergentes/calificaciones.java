/*
 */
package com.emergentes;
package com.ejemplo;

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
            // Código para agregar una calificación
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            eliminarCalificacion(calificaciones, id);
            reorganizarIds(calificaciones);
        }

        response.sendRedirect(request.getContextPath() + "/calificaciones");
    }

    private void eliminarCalificacion(ArrayList<calificacion> calificaciones, int id) {
    for (int i = 0; i < calificaciones.size(); i++) {
        if (calificaciones.get(i).getId() == id) {
            calificaciones.remove(i);
            break; // Importante: salir del bucle después de eliminar el elemento
        }
    }
}


    private void reorganizarIds(ArrayList<calificacion> calificaciones) {
        for (int i = 0; i < calificaciones.size(); i++) {
            calificaciones.get(i).setId(i + 1);
        }
    }
}
