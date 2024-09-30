package com.api.api.service;

import com.api.api.dto.CategoriaDto;
import com.api.api.model.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> listarTodas();

    Categoria findById(Integer id);

    Categoria create(CategoriaDto dto);

    Categoria update(Integer id ,CategoriaDto dto);

    void delete(Integer id);
}
