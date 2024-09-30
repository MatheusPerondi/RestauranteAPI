package com.api.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PratoDto {

    private Integer id;

    @NotBlank(message = "valor não pode ser nulo")
    private String nome;

    @NotBlank(message = "valor não pode ser nulo")
    private String descricao;

    private Double preco;

    @NotNull
    private Integer categoriaId;
}
