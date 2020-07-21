package com.example.gestorsp.gestorsp.models;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Embeddable
public class ReservaId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name="horarioId")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;
    @ManyToOne
    //@MapsId("numero_sillon")
    //@JoinColumn(name="numero_sillon",referencedColumnName = "numero_sillon")
    private Sillon sillon;


    public void setSillon(Sillon sillonid) {
        this.sillon = sillonid;
    }
    public Sillon getSillon() {
        return sillon;
    }
    public void setHorario(Date horario) {
        this.horario = horario;
    }
    public Date getHorario() {
        return horario;
    }

    public ReservaId(){
    
    }

    public ReservaId(Sillon sillon,Date horario){
        this.horario=horario;
        this.sillon=sillon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservaId)) return false;
        Reserva that = (Reserva) o;
        return 
                Objects.equals(getHorario(), that.getHorario()) &&
                Objects.equals(getSillon(), that.getSillon());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(
            getHorario(),
            getSillon());
    }

}