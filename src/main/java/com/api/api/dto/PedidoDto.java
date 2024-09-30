package com.api.api.dto;

import com.api.api.model.Prato;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDto {

    private Integer id;

    @NotNull
    private LocalDate dataPedido;

    @NotNull
    private LocalTime horaPedido;

    @NotNull
    private Integer pratoId;

    @NotNull
    private Integer bebidaId;
}
