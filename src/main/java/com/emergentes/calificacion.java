/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes;
/**
 *
 * @author Ramos
 */
public class calificacion {
    private static int nextId = 1;
    private int id;
    private String nombre;
    private int primerParcial;
    private int segundoParcial;
    private int examenFinal;
    private int notaFinal;

    public calificacion(String nombre, int primerParcial, int segundoParcial, int examenFinal) {
        this.id = nextId++;
        this.nombre = nombre;
        this.primerParcial = primerParcial;
        this.segundoParcial = segundoParcial;
        this.examenFinal = examenFinal;
        this.notaFinal = calcularNotaFinal();
    }

    int calcularNotaFinal() {
        return primerParcial + segundoParcial + examenFinal;
    }

    // Getters y Setters

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        calificacion.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrimerParcial() {
        return primerParcial;
    }

    public void setPrimerParcial(int primerParcial) {
        this.primerParcial = primerParcial;
    }

    public int getSegundoParcial() {
        return segundoParcial;
    }

    public void setSegundoParcial(int segundoParcial) {
        this.segundoParcial = segundoParcial;
    }

    public int getExamenFinal() {
        return examenFinal;
    }

    public void setExamenFinal(int examenFinal) {
        this.examenFinal = examenFinal;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }
    
}

