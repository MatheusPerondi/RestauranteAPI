package com.api.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Integer id;

    private LocalDate dataPedido;

    private LocalTime horaPedido;

    @ManyToOne
    @JoinColumn(name = "prato_id")
    private Prato prato;

    @ManyToOne
    @JoinColumn(name = "bebida_id")
    private Bebida bebida;
}
