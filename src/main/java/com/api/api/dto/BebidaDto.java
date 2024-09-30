package com.api.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BebidaDto {

    private Integer id;

    @NotBlank(message = "valor não pode ser nulo")
    private String nome;

    @NotBlank(message = "valor não pode ser nulo")
    @Size(min = 10, max = 30)
    private String descricao;

    @NotNull
    private Double preco;

    @NotNull
    private Integer IdCategoria;
}
