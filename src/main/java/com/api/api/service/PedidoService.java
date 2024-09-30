package com.api.api.service;

import com.api.api.dto.PedidoDto;
import com.api.api.model.Categoria;
import com.api.api.model.Pedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> listarTodas();

    Pedido findById(Integer id);

    Pedido create(PedidoDto dto);

    Pedido update(Integer id ,PedidoDto dto);

    void delete(Integer id);
}
