<%-- 
    Document   : index
    Created on : 02-abr-2024, 19:42:53
    Author     : Ramos
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.emergentes.calificacion" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        .texh{
            text-align:center
        }
    </style>
</head>
<body>
    <table style="margin: 0 auto;" border="10">
        <tr>
            <th><i><p class="texh">PRIMER PARCIAL TEM-742</p>
            <p class="texh">Nombre: Adriana Pinto Ramos</p>
            <p class="texh">Carnet: 9580702 S.C</p></i></th>
        </tr>
    </table>   
    <h2 class="texh">Registro de Calificaciones</h2>
    <button><a href="nueva_calificacion.jsp">Nuevo</a></button><h2></h2>
    <table border="5">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>P1(30)</th>
            <th>P2(30)</th>
            <th>EF</th>
            <th>Nota</th>
            <th>Acciones</th>
        </tr>
        <% 
        ArrayList<calificacion> calificaciones = (ArrayList<calificacion>) session.getAttribute("calificaciones");
        if (calificaciones != null) {
            for (calificacion calificacion : calificaciones) {
        %>
        <tr>
            <td><%= calificacion.getId() %></td>
            <td><%= calificacion.getNombre() %></td>
            <td><%= calificacion.getPrimerParcial() %></td>
            <td><%= calificacion.getSegundoParcial() %></td>
            <td><%= calificacion.getExamenFinal() %></td>
            <td><%= calificacion.getNotaFinal() %></td>
            <td>
                <form action="calificaciones" method="POST">
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="id" value="<%= calificacion.getId() %>">
                    <input type="text" name="nombre" value="<%= calificacion.getNombre() %>" required>
                    <input type="number" name="primerParcial" min="0" max="30" value="<%= calificacion.getPrimerParcial() %>" required>
                    <input type="number" name="segundoParcial" min="0" max="30" value="<%= calificacion.getSegundoParcial() %>" required>
                    <input type="number" name="examenFinal" min="0" max="40" value="<%= calificacion.getExamenFinal() %>" required>
                    <input type="submit" value="Editar">
                </form>
                <form action="calificaciones" method="POST">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= calificacion.getId() %>">
                    <input type="submit" value="Eliminar">
                </form>
            </td>
        </tr>
        <% 
            }
        } 
        %>
    </table>
    
    
</body>
</html>
