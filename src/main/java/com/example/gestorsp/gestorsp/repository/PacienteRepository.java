package com.example.gestorsp.gestorsp.repository;
import com.example.gestorsp.gestorsp.models.Paciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente,Long> {
}