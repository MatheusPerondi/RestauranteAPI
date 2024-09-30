package com.api.api.controller;

import com.api.api.dto.BebidaDto;
import com.api.api.model.Bebida;
import com.api.api.service.BebidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bebida")
public class BebidaController {

    @Autowired
    private BebidaService bebidaService;

    @GetMapping
    public ResponseEntity<List<Bebida>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bebida> findById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Bebida> create (@Valid @RequestBody BebidaDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bebidaService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bebida> update(@PathVariable("id") Integer id, @RequestBody BebidaDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(bebidaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bebida> delete(@PathVariable("id") Integer id){
        bebidaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
