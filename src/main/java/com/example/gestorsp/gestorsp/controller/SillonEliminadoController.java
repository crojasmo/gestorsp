package com.example.gestorsp.gestorsp.controller;

import com.example.gestorsp.gestorsp.models.SillonEliminado;
import com.example.gestorsp.gestorsp.repository.SillonEliminadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import com.example.gestorsp.gestorsp.exceptions.*;



@CrossOrigin
@RestController
public class SillonEliminadoController {
    @Autowired
    private SillonEliminadoRepository sillonEliminadoRepository;
    @GetMapping("/silloneseliminados")
    public Iterable<SillonEliminado> getSillonEliminado(Pageable pageable){
        return sillonEliminadoRepository.findAll();
    }

    @GetMapping("/silloneseliminados/{sillonId}")
    public SillonEliminado getSillonDetalle(Pageable pageable,@PathVariable Long sillonId){
        return sillonEliminadoRepository.findById(sillonId).map(sillon->{
            return sillonEliminadoRepository.save(sillon);
        }).orElseThrow(()-> new ResourceNotFoundException("Sillon Eliminado not found with id " + sillonId));
    }

}