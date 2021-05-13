package com.loja.floricultura.controller;

import com.loja.floricultura.Dto.CompraDto;
import com.loja.floricultura.model.Compra;
import com.loja.floricultura.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public Compra realizarCompra(@RequestBody CompraDto compra){
        return compraService.realizaCompra(compra);
    }
}

