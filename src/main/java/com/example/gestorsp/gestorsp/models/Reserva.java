package com.example.gestorsp.gestorsp.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Reserva")
public class Reserva {
    @EmbeddedId
    private ReservaId reservaId;
    @ManyToOne
    //@MapsId("paciente_id")
    //@JoinColumn(name="paciente_id",referencedColumnName = "dau")
    private Paciente paciente;

    public void setSillon(Sillon sillon) {
        this.reservaId.setSillon(sillon);
    }
    public Sillon getSillon(){
        return this.reservaId.getSillon();
    }
    public Date getHorario(){
        return this.reservaId.getHorario();
    }
    public void setReservaId(ReservaId reservaId) {
        this.reservaId = reservaId;
    }
    public ReservaId getReservaId() {
        return reservaId;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente_id) {
        this.paciente= paciente_id;
    }

    public Reserva(ReservaId reservaid){
        this.reservaId=reservaid;
    }
   
    public Reserva(){

    }

    
}