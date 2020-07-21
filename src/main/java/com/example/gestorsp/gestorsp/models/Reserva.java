package com.example.gestorsp.gestorsp.models;

import javax.persistence.*;

@Entity
@Table(name = "Reserva")
public class Reserva {
    @EmbeddedId
    private ReservaId reservaId;
    @ManytoOne
    @MapsId("numero_sillon")
    @JoinColumn(name="numero_sillon",referencedColumnName = "numero_sillon")
    Sillon sillon;
    //Agregar Paciente

    public void setSillon(Sillon sillon) {
        this.reservaId.setSillonid(sillon);
    }
    public Long getSillon(){
        return this.reservaId.getSillonid();
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