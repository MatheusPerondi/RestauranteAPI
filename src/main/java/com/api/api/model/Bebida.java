package com.api.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bebidas")
public class Bebida  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bebida_id")
    private Integer id;

    private String nome;


    private String descricao;

    private Double preco;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
