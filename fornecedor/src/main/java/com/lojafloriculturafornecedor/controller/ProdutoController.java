package com.lojafloriculturafornecedor.controller;

import com.lojafloriculturafornecedor.model.Produto;
import com.lojafloriculturafornecedor.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping("/{estado}")
    public List<Produto> getProdutosPorEstado(@PathVariable("estado") String estado) {
        return produtoService.getProdutosPorEstado(estado);
    }
}
