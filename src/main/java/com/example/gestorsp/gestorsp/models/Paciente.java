package com.example.gestorsp.gestorsp.models;


import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    private Long dau ;
    private String diagnostico;
    private String Rut;
    private Long n_ficha_clinica;
    private boolean extranjero;
    private boolean recien_nacido;
    private String nombre;
    private String apellido;
    private String genero;
    @Temporal(TemporalType.DATE)
    private Calendar fecha_nacimiento;
    private String rango_edad;
    private String direccion;
    private String telefono;
    private String telefono2;
    private String estado;
    
    public Paciente() {

    }
    public Paciente(Long dau) {
        this.dau=dau;
    }

    public void setDau(Long dau) {
        this.dau = dau;
    }
    public Long getDau() {
        return dau;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getApellido() {
        return apellido;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getEstado() {
        return estado;
    }
    public void setExtranjero(boolean extranjero) {
        this.extranjero = extranjero;
    }
    public boolean getExtranejero(){
        return this.extranjero;
    }
    public void setFecha_nacimiento(Calendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public Calendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getGenero() {
        return genero;
    }
    public void setN_ficha_clinica(Long n_ficha_clinica) {
        this.n_ficha_clinica = n_ficha_clinica;
    }
    public Long getN_ficha_clinica() {
        return n_ficha_clinica;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setRango_edad(String rango_edad) {
        this.rango_edad = rango_edad;
    }
    public String getRango_edad() {
        return rango_edad;
    }
    public void setRecien_nacido(boolean recien_nacido) {
        this.recien_nacido = recien_nacido;
    }
    public boolean getRecien_nacido(){
        return this.recien_nacido;
    }
    public void setRut(String rut) {
        Rut = rut;
    }
    public String getRut() {
        return Rut;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }
    public String getTelefono2() {
        return telefono2;
    }

}