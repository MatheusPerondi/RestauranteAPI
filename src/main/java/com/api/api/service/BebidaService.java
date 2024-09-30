package com.api.api.service;

import com.api.api.dto.BebidaDto;
import com.api.api.model.Bebida;
import com.api.api.model.Categoria;

import java.util.List;

public interface BebidaService {

    List<Bebida> listarTodas();

    Bebida findById(Integer id);

    Bebida create(BebidaDto dto);

    Bebida update(Integer id , BebidaDto dto);

    void delete(Integer id);
}
