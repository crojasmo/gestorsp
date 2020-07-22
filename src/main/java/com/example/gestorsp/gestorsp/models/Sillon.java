package com.example.gestorsp.gestorsp.models;


import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "sillon")
public class Sillon {
    @Id
    @GeneratedValue
    private Long numero_sillon;
    private String estado;
    private boolean activo;
    private Long numero_sala;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_retirado;
    public Sillon(){

    }

    public Sillon (Long numero_sillon){
        this.numero_sillon=numero_sillon;
    }
    public Sillon (Long numero_sillon, Long numero_sala){
        this.numero_sillon=numero_sillon;
        this.numero_sala=numero_sala;
    }
    public void setNumero_sillon(Long numero_sillon) {
        this.numero_sillon = numero_sillon;
    }
    public Long getNumero_sillon() {
        return numero_sillon;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public boolean getActivo(){
        return activo;
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

    public void setFecha_retirado(Date fecha_retirado) {
        Fecha_retirado = fecha_retirado;
    }
    public Date getFecha_retirado() {
        return Fecha_retirado;
    }
    
    
}