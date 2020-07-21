package com.example.gestorsp.gestorsp.models;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.*;

@Embeddable
public class ReservaId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name="horarioId")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp horario;
    @Column(name="sillonId")
    private Long sillonid;


    public void setSillonid(Long sillonid) {
        this.sillonid = sillonid;
    }
    public Long getSillonid() {
        return sillonid;
    }
    public void setHorario(Timestamp horario) {
        this.horario = horario;
    }
    public Timestamp getHorario() {
        return horario;
    }

    public ReservaId(){
    
    }

    public ReservaId(Long sillon,Timestamp horario){
        this.horario=horario;
        this.sillonid=sillon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservaId)) return false;
        Reserva that = (Reserva) o;
        return 
                Objects.equals(getHorario(), that.getHorario()) &&
                Objects.equals(getSillonid(), that.getSillonid());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(
            getHorario(),
            getSillonid());
    }

}