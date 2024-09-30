package com.api.api.dto;

import jakarta.validation.constraints.NotBlank;
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
public class ReservaDto {

    private Integer id;

    @NotBlank
    private String nomeCliente;

    @NotNull
    private LocalDate dataReserva;

    @NotNull
    private LocalTime horaReserva;

    @NotNull
    private Integer numPessoas;
}
