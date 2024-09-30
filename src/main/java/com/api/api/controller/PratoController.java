package com.api.api.controller;

import com.api.api.dto.PratoDto;
import com.api.api.model.Prato;
import com.api.api.service.PratoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prato")
public class PratoController {

    @Autowired
    private PratoService pratoService;

    @GetMapping()
    public ResponseEntity<List<Prato>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(pratoService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prato> findById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(pratoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Prato> create(@Valid @RequestBody PratoDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pratoService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prato> update(@PathVariable("id") Integer id, @RequestBody PratoDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(pratoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Prato> delete(@PathVariable("id") Integer id){
        pratoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
