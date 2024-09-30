package com.api.api.service;

import com.api.api.dto.PratoDto;
import com.api.api.model.Categoria;
import com.api.api.model.Prato;

import java.util.List;

public interface PratoService {

    List<Prato> listarTodas();

    Prato findById(Integer id);

    Prato create(PratoDto dto);

    Prato update(Integer id ,PratoDto dto);

    void delete(Integer id);
}
