package com.api.api.mapper;

import com.api.api.dto.BebidaDto;
import com.api.api.model.Bebida;
import com.api.api.model.Categoria;

public class BebidaMapper {

    public static Bebida fromDtoToEntity(BebidaDto dto, Categoria categoria){
        return Bebida.builder()
                .id(dto.getId())
                .categoria(categoria)
                .preco(dto.getPreco())
                .descricao(dto.getDescricao())
                .nome(dto.getNome())
                .build();
    }
}
