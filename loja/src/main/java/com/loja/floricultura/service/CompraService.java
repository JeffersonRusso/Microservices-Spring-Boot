package com.loja.floricultura.service;

import com.loja.floricultura.Dto.CompraDto;
import com.loja.floricultura.Dto.InfoFornecedorDto;
import com.loja.floricultura.Dto.InfoPedidoDto;
import com.loja.floricultura.client.FornecedorClient;
import com.loja.floricultura.model.Compra;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompraService {

    public static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private FornecedorClient fornecedorClient;



    public Compra realizaCompra(CompraDto compra) {

        LOG.info("buscando informações do fornecedor de {}", compra.getEndereco().getEstado());
        InfoFornecedorDto informacoesFornecedorDto = fornecedorClient.getInforPorEstado(compra.getEndereco().getEstado());

        LOG.info("realizando um pedido");
        InfoPedidoDto infoPedidoDto = fornecedorClient.realizaPedido(compra.getItens());

        System.out.println(informacoesFornecedorDto.getEstado());

        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(infoPedidoDto.getId());
        compraSalva.setTempoDePrepapo(infoPedidoDto.getTempoDePreparo());
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());

        return compraSalva;
    }
}
