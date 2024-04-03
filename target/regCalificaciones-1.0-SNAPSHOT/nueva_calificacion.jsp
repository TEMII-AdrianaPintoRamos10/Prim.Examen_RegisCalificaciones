<%-- 
    Document   : nueva_calificacion
    Created on : 02-abr-2024, 19:53:14
    Author     : Ramos
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Nueva Calificación</title>
    <style>
        .cen{
            text-align: center;
        }
    </style>
</head>
<body>
    <table style="margin: 0 auto;" border="10" >
        <tr>
            <th><i><p class="texh">PRIMER PARCIAL TEM-742</p>
            <p class="texh">Nombre: Adriana Pinto Ramos</p>
            <p class="texh">Carnet: 9580702 S.C</p></i></th>
        </tr>
    </table>
    <h2 class="cen">Registro de Calificaciones</h2>
    <table  border ="5" class="cen"><tr><th>
    <form action="calificaciones" method="POST">
        <input type="hidden" name="action" value="add">
        Nombre del estudiante:  <input type="text" name="nombre" required><br>
        Primer Parcial (sobre 30): <input type="number" name="primerParcial" min="0" max="30" required><br>
        Segundo Parcial (sobre 30): <input type="number" name="segundoParcial" min="0" max="30" required><br>
        Examen Final (sobre 40):  <input type="number" name="examenFinal" min="0" max="40" required><br>
        <input type="submit" value="Enviar">
    </form>
    </th></tr></table>
</body>
</html>

