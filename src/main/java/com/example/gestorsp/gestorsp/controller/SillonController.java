package com.example.gestorsp.gestorsp.controller;

import com.example.gestorsp.gestorsp.models.Motivo;
import com.example.gestorsp.gestorsp.models.Sillon;
import com.example.gestorsp.gestorsp.repository.SillonRepository;
import com.example.gestorsp.gestorsp.models.SillonEliminado;
import com.example.gestorsp.gestorsp.repository.SillonEliminadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.gestorsp.gestorsp.exceptions.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RestController
public class SillonController {
    @Autowired
    private SillonRepository sillonRepository;
    @Autowired
    private SillonEliminadoRepository sillonEliminadoRepository;
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    @GetMapping("/sillones")
    public Iterable<Sillon> getSillon(Pageable pageable){
        return sillonRepository.findByActivo(true);
    }
    @GetMapping("/sillones/eliminados")
    public Iterable<Sillon> getSillonEliminado(Pageable pageable){
        return sillonRepository.findByActivo(false);  
    }
    @GetMapping("/sillones/completa")
    public Iterable<Sillon> getSillonCompleto(Pageable pageable){
        return sillonRepository.findAll();   
    }

    @GetMapping("/sillones/{sillonId}")
    public Sillon getSillonDetalle(Pageable pageable,@PathVariable Long sillonId){
        if (sillonRepository.findById(sillonId).get().getActivo()==false) {
            throw new DeletedException("Sillon con la id: "+ sillonId +" ya eliminado");
        } 
            return sillonRepository.findById(sillonId).map(sillon->{
                return sillonRepository.save(sillon);
            }).orElseThrow(()-> new ResourceNotFoundException("Sillon not found with id " + sillonId));
        
        
    }
    @PostMapping("/sillones")
    public Sillon createSillon(@Validated @RequestBody Sillon sillon_n) {
        Date fecha_hora=new Date();
        sillon_n.setFecha_creacion(fecha_hora);
        Sillon newSillon=sillonRepository.save(sillon_n);
        return newSillon;
    }

    @PutMapping("/sillones/{sillonId}")
    public Sillon sillonUpdate(@PathVariable Long sillonId,@Validated @RequestBody Sillon sillonRequest){
        return sillonRepository.findById(sillonId)
            .map(sillon -> {
                sillon.setActivo(sillonRequest.getActivo());
                sillon.setNumero_sala(sillonRequest.getNumero_sala());
                sillon.setNumero_sillon(sillonRequest.getNumero_sillon());
                Date fecha_hora=new Date();
                sillon.setFecha_update(fecha_hora);

                return sillonRepository.save(sillon);
            }).orElseThrow(() -> new ResourceNotFoundException("Sillon no encontrado con id: " + sillonId));
    }


    @DeleteMapping("/sillones/{sillonId}/delete")
    public Sillon sillonDelete(@PathVariable Long sillonId,@Validated @RequestBody Motivo motivo){
        if (sillonRepository.findById(sillonId).get().getActivo()==false){
            throw new DeletedException("Sillon con la id: "+ sillonId +" ya eliminado");
        }
        return sillonRepository.findById(sillonId)
            .map(sillon -> {
                sillon.setActivo(false);
                Date fecha_hora=new Date();
                sillon.setFecha_retirado(fecha_hora);
                sillonEliminadoCrear(sillon,motivo.getMotivo());
                return sillonRepository.save(sillon);
            }).orElseThrow(() -> new ResourceNotFoundException("Sillon no encontrado con id: " + sillonId));
    }
    public SillonEliminado sillonEliminadoCrear(Sillon sillon,String motivo){
        Long id=sillon.getId();
        String numero_sillon=sillon.getNumero_sillon();
        Date fecha_creacion=sillon.getFecha_creacion();
        Date fecha_eliminacion=new Date();
        SillonEliminado sillon_eliminado= new SillonEliminado();
        sillon_eliminado.setId_original_sillon(id);
        sillon_eliminado.setFecha_creacion(fecha_creacion);
        sillon_eliminado.setFecha_eliminacion(fecha_eliminacion);
        sillon_eliminado.setNumero_sillon(numero_sillon);
        sillon_eliminado.setMotivo(motivo);
        return sillonEliminadoRepository.save(sillon_eliminado);

    }
    }
    