package com.api.api.controller;

import com.api.api.dto.PedidoDto;
import com.api.api.model.Pedido;
import com.api.api.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Pedido> create(@Valid @RequestBody PedidoDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable("id") Integer id, @RequestBody PedidoDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> delete(@PathVariable("id") Integer id){
        pedidoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
