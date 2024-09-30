package com.api.api.mapper;

import com.api.api.dto.PedidoDto;
import com.api.api.model.Bebida;
import com.api.api.model.Pedido;
import com.api.api.model.Prato;

public class PedidoMapper {

    public static Pedido fromDtoToEntity(PedidoDto dto, Prato prato, Bebida bebida){
        return Pedido.builder()
                .id(dto.getId())
                .dataPedido(dto.getDataPedido())
                .horaPedido(dto.getHoraPedido())
                .bebida(bebida)
                .prato(prato)
                .build();
    }
}
