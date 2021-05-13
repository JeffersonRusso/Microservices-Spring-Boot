package com.lojafloriculturafornecedor.controller;

import com.lojafloriculturafornecedor.model.infomacoesFornecedor;
import com.lojafloriculturafornecedor.service.InformacoesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class informacaoController {

    public static final Logger LOG = LoggerFactory.getLogger(informacaoController.class);

    @Autowired
    private InformacoesService informacoesService;

    @GetMapping("/{estado}")
    public infomacoesFornecedor getInformacoesPorEstado(@PathVariable String estado) {

        LOG.info("RECEBIDO PEDIDO DE INFORMAÇÕES DO FORNECEDOR DE {}", estado);
        return informacoesService.getInformacoesPorEstado(estado);
    }

}
