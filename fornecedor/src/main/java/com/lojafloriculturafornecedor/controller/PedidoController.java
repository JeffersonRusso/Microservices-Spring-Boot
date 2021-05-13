package com.lojafloriculturafornecedor.controller;

import com.lojafloriculturafornecedor.dto.ItemDoPedidoDTO;
import com.lojafloriculturafornecedor.model.Pedido;
import com.lojafloriculturafornecedor.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    public static final Logger LOG = LoggerFactory.getLogger(informacaoController.class);

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(method = RequestMethod.POST)
    public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
        LOG.info("PEDIDO RECEBIDO");
        return pedidoService.realizarPedido(produtos);
    }

    @RequestMapping("/{id}")
    public Pedido getPedidoPorId(@PathVariable Long id) {
        return pedidoService.getPedidoPorId(id);
    }
}
