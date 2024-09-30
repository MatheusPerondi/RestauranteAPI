package com.api.api.service;

import com.api.api.dto.ReservaDto;
import com.api.api.model.Categoria;
import com.api.api.model.Reserva;

import java.util.List;

public interface ReservaService {

    List<Reserva> listarTodas();

    Reserva findById(Integer id);

    Reserva create(ReservaDto dto);

    Reserva update(Integer id ,ReservaDto dto);

    void delete(Integer id);
}
