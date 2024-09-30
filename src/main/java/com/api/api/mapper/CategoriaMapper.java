package com.api.api.mapper;

import com.api.api.dto.CategoriaDto;
import com.api.api.model.Categoria;

public class CategoriaMapper {

    public static Categoria fromDtoToEntity(CategoriaDto dto){
        return Categoria.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .build();
    }
}
