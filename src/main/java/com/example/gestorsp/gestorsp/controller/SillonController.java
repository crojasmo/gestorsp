package com.example.gestorsp.gestorsp.controller;

import com.example.gestorsp.gestorsp.models.Sillon;
import com.example.gestorsp.gestorsp.repository.SillonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.gestorsp.gestorsp.exceptions.ResourceNotFoundException;


@RestController
public class SillonController {
    @Autowired
    private SillonRepository sillonRepository;

    @GetMapping("/sillones")
    public Iterable<Sillon> getSillon(Pageable pageable){
        return sillonRepository.findAll();
    }

    @GetMapping("/sillones/{sillonId}")
    public Sillon getSillonDetalle(Pageable pageable,@PathVariable Long sillonId){
        return sillonRepository.findById(sillonId).map(sillon->{
            return sillonRepository.save(sillon);
        }).orElseThrow(()-> new ResourceNotFoundException("Sillon not found with id " + sillonId));
    }
    

}