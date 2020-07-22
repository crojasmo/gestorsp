package com.example.gestorsp.gestorsp.repository;
import java.util.List;

import com.example.gestorsp.gestorsp.models.Sillon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SillonRepository extends CrudRepository<Sillon,Long> {
    List<Sillon> findByActivo(boolean activo);

}
