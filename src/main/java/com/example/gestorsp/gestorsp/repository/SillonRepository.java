package com.example.gestorsp.gestorsp.repository;
import com.example.gestorsp.gestorsp.models.Sillon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SillonRepository extends CrudRepository<Sillon,Long> {
}
