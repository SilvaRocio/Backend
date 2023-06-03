package com.example.clase23s.models;

import com.example.clase23s.models.Odontologo;

import java.time.LocalDate;

public class Paciente {
    private long id;
    private String apellido;
    private String nombre;
    private String mail;
    private String dni;
    private LocalDate fechaIngreso;
    private Odontologo odontologo;

    //private Domicilios domicilios;

    public Paciente(long id, String apellido, String nombre, String mail, String dni, LocalDate fechaIngreso, Odontologo odontologo) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.mail = mail;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.odontologo = odontologo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
}
