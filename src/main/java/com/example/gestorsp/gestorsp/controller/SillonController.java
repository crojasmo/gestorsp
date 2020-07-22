package com.example.gestorsp.gestorsp.controller;

import com.example.gestorsp.gestorsp.models.Sillon;
import com.example.gestorsp.gestorsp.repository.SillonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import com.example.gestorsp.gestorsp.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class SillonController {
    @Autowired
    private SillonRepository sillonRepository;

    @GetMapping("/sillones")
    public Iterable<Sillon> getSillon(Pageable pageable){
        Iterable<Sillon> lista_completa=sillonRepository.findAll();
        Iterator i=lista_completa.iterator();
        boolean act=true;
        while (i.hasNext()) {
            Sillon sillon_n=(Sillon)i.next();
            act=sillon_n.getActivo();
            if (act==false) {
                i.remove();
            }
        }
        return lista_completa;   
    }
    @GetMapping("/sillones/eliminados")
    public Iterable<Sillon> getSillonEliminado(Pageable pageable){
        Iterable<Sillon> lista_completa=sillonRepository.findAll();
        Iterator i=lista_completa.iterator();
        boolean act=true;
        while (i.hasNext()) {
            Sillon sillon_n=(Sillon)i.next();
            act=sillon_n.getActivo();
            if (act==true) {
                i.remove();
            }
        }
        return lista_completa;   
    }
    @GetMapping("/sillones/completa")
    public Iterable<Sillon> getSillonCompleto(Pageable pageable){
        return sillonRepository.findAll();   
    }

    @GetMapping("/sillones/{sillonId}")
    public Sillon getSillonDetalle(Pageable pageable,@PathVariable Long sillonId){
        return sillonRepository.findById(sillonId).map(sillon->{
            return sillonRepository.save(sillon);
        }).orElseThrow(()-> new ResourceNotFoundException("Sillon not found with id " + sillonId));
    }
    @PostMapping("/sillones")
    public Sillon createSillon(@Validated @RequestBody Sillon sillon_n) {
        Sillon newSillon=sillonRepository.save(sillon_n);
        return newSillon;
    }

    @PutMapping("/sillones/{sillonId}")
    public Sillon sillonUpdate(@PathVariable Long sillonId,@Validated @RequestBody Sillon sillonRequest){
        return sillonRepository.findById(sillonId)
            .map(sillon -> {
                sillon.setActivo(sillonRequest.getActivo());
                sillon.setEstado(sillonRequest.getEstado());
                sillon.setNumero_sala(sillonRequest.getNumero_sala());
                sillon.setNumero_sillon(sillonRepository.findById(sillonId).get().getNumero_sillon());
                return sillonRepository.save(sillon);
            }).orElseThrow(() -> new ResourceNotFoundException("Sillon no encontrado con id: " + sillonId));
    }
    @PutMapping("/sillones/{sillonId}/delete")
    public Sillon sillonDelete(@PathVariable Long sillonId){
        return sillonRepository.findById(sillonId)
            .map(sillon -> {
                sillon.setActivo(false);
                sillon.setEstado("No disponible");
                SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha_hora=new Date();
                sillon.setFecha_retirado(fecha_hora);
                return sillonRepository.save(sillon);
            }).orElseThrow(() -> new ResourceNotFoundException("Sillon no encontrado con id: " + sillonId));
    }
    }
    