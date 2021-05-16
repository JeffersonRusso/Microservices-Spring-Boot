package com.loja.floricultura.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDto {

    private String rua;
    private int numero;
    private String estado;

    @Override
    public String toString() {
        return "EnderecoDto{" +
                "rua='" + rua + '\'' +
                ", numero=" + numero +
                ", estado='" + estado + '\'' +
                '}';
    }
}
