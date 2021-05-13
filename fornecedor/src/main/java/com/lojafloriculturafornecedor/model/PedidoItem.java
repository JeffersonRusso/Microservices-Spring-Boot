package com.lojafloriculturafornecedor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PedidoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Integer quantidade;

    @ManyToOne @JoinColumn(name = "produtoId")
    private Produto produto;

}
