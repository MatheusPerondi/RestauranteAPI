package com.api.api.controller;

import com.api.api.dto.ReservaDto;
import com.api.api.model.Reserva;
import com.api.api.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> findById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Reserva> create(@Valid @RequestBody ReservaDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(@PathVariable("id") Integer id, @RequestBody ReservaDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reserva> delete(@PathVariable("id") Integer id){
        reservaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
