package com.loja.floricultura.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompraDto {

    private List<ItemDaCompraDto> itens;
    private EnderecoDto endereco;
}
