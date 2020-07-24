package com.example.gestorsp.gestorsp.models;


import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "sillon")
public class Sillon {
    @Id
    @GeneratedValue
    private Long id;
    private String numero_sillon;
    private String estado;
    private boolean activo;
    private Long numero_sala;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_update;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_creacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_retirado;
    public Sillon(){

    }


    public Sillon (String numero_sillon){
        this.numero_sillon=numero_sillon;
    }
    public Sillon (String numero_sillon, Long numero_sala){
        this.numero_sillon=numero_sillon;
        this.numero_sala=numero_sala;
    }
    public void setNumero_sillon(String numero_sillon) {
        this.numero_sillon = numero_sillon;
    }
    public String getNumero_sillon() {
        return numero_sillon;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setNumero_sala(Long numero_sala) {
        this.numero_sala = numero_sala;
    }
    public Long getNumero_sala() {
        return numero_sala;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public boolean getActivo(){
        return this.activo;
    }
    public Date getFecha_creacion() {
        return Fecha_creacion;
    }
    public void setFecha_creacion(Date fecha_creacion) {
        Fecha_creacion = fecha_creacion;
    }
    public Date getFecha_update() {
        return Fecha_update;
    }
    public void setFecha_update(Date fecha_update) {
        Fecha_update = fecha_update;
    }
    public void setFecha_retirado(Date fecha_retirado) {
        Fecha_retirado = fecha_retirado;
    }
    public Date getFecha_retirado() {
        return Fecha_retirado;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    
}