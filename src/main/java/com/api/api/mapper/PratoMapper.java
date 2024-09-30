package com.api.api.mapper;

import com.api.api.dto.PratoDto;
import com.api.api.model.Categoria;
import com.api.api.model.Prato;

public class PratoMapper {

    public static Prato fromDtoToEntity(PratoDto dto, Categoria categoria){
        return Prato.builder()
                .id(dto.getId())
                .preco(dto.getPreco())
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .categoria(categoria)
                .build();
    }
}
