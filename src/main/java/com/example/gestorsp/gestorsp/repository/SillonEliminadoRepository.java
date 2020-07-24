package com.example.gestorsp.gestorsp.repository;
import com.example.gestorsp.gestorsp.models.SillonEliminado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SillonEliminadoRepository extends CrudRepository<SillonEliminado,Long> {
}
