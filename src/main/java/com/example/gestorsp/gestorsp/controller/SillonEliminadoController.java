package com.example.gestorsp.gestorsp.controller;

import com.example.gestorsp.gestorsp.models.Sillon;
import com.example.gestorsp.gestorsp.models.SillonEliminado;
import com.example.gestorsp.gestorsp.repository.SillonEliminadoRepository;
import com.example.gestorsp.gestorsp.repository.SillonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

import com.example.gestorsp.gestorsp.exceptions.*;



@CrossOrigin
@RestController
public class SillonEliminadoController {
    @Autowired
    private SillonEliminadoRepository sillonEliminadoRepository;
    private SillonRepository sillonRepository;
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
    @DeleteMapping("silloneseliminados/{sillonId}/devolver")
    public Sillon sillonRevive(@PathVariable Long sillonId){
        if (sillonRepository.findById(sillonId).get().getActivo()==false){
            throw new DeletedException("Sillon con la id: "+ sillonId +" no esta eliminado");
        }
        return sillonRepository.findById(sillonId)
            .map(sillon -> {
                sillon.setActivo(true);
                Date fecha_hora=new Date();
                sillon.setFecha_update(fecha_hora);
                return sillonRepository.save(sillon);
            }).orElseThrow(() -> new ResourceNotFoundException("Sillon no encontrado con id: " + sillonId));
    }
    }

