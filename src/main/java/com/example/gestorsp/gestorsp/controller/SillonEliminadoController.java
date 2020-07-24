package com.example.gestorsp.gestorsp.controller;

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



@RestController
public class SillonEliminadoController {
    @Autowired
    private SillonEliminadoRepository sillonEliminadoRepository;
    @GetMapping("/sillones")
    public Iterable<SillonEliminado> getSillonEliminado(Pageable pageable){
        return sillonEliminadoRepository.findAll();
    }

}