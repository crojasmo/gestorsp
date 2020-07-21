package com.example.gestorsp.gestorsp.repository;
import com.example.gestorsp.gestorsp.models.Reserva;
import com.example.gestorsp.gestorsp.models.ReservaId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva,ReservaId>{
}