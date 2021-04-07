package com.example.semana3_3.Objetos;

import java.io.Serializable;

public class Mascota implements Serializable {


    //ATRIBUTOS
    int id;
    String nombre;
    int edad;
    int rate=0;
    int foto;
    String especie;
    String raza;
    String dueño;

    public Mascota(String nombre, int edad, String especie, String raza, String dueño, int foto,int id) {
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.raza = raza;
        this.dueño = dueño;
        this.foto=foto;
    }

    public Mascota(String nombre, int edad, String especie, String raza, String dueño, int foto, int rate, int id) {
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.raza = raza;
        this.dueño = dueño;
        this.foto=foto;
        this.rate=rate;
    }

    public Mascota() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
