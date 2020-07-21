package com.example.gestorsp.gestorsp.models;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "Reserva")
public class Reserva {
    @EmbeddedId
    private ReservaId reservaId;
    @ManyToOne
    @MapsId("numero_sillon")
    @JoinColumn(name="numero_sillon",referencedColumnName = "numero_sillon")
    Sillon sillon;
    //Agregar Paciente

    public void setSillonid(Long sillon) {
        this.reservaId.setSillonid(sillon);
    }
    public Long getSillonid(){
        return this.reservaId.getSillonid();
    }
    public Timestamp getHorario(){
        return this.reservaId.getHorario();
    }
    public void setReservaId(ReservaId reservaId) {
        this.reservaId = reservaId;
    }
    public ReservaId getReservaId() {
        return reservaId;
    }
    public Reserva(ReservaId reservaid){
        this.reservaId=reservaid;
    }
   
    public Reserva(){

    }

    
}