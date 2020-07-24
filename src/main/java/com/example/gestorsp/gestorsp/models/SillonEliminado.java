package com.example.gestorsp.gestorsp.models;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "sillon_eliminado")
public class SillonEliminado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_original_sillon;
    private String numero_sillon;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_eliminacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date Fecha_creacion;
    private String motivo;

    public SillonEliminado(){
    }
    public void setId_original_sillon(Long id_original_sillon) {
        this.id_original_sillon = id_original_sillon;
    }
    public Long getId_original_sillon() {
        return id_original_sillon;
    }
    public void setFecha_creacion(Date fecha_creacion) {
        Fecha_creacion = fecha_creacion;
    }
    public Date getFecha_creacion() {
        return Fecha_creacion;
    }
    public void setFecha_eliminacion(Date fecha_eliminacion) {
        Fecha_eliminacion = fecha_eliminacion;
    }
    public Date getFecha_eliminacion() {
        return Fecha_eliminacion;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setNumero_sillon(String numero_sillon) {
        this.numero_sillon = numero_sillon;
    }
    public String getNumero_sillon() {
        return numero_sillon;
    }
}