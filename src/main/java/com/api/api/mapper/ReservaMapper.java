package com.api.api.mapper;

import com.api.api.dto.ReservaDto;
import com.api.api.model.Reserva;

public class ReservaMapper {

    public static Reserva fromDtoToEntity(ReservaDto dto){
        return Reserva.builder()
                .id(dto.getId())
                .nomeCliente(dto.getNomeCliente())
                .dataReserva(dto.getDataReserva())
                .horaReserva(dto.getHoraReserva())
                .numPessoas(dto.getNumPessoas())
                .build();
    }
}
