package com.lojafloriculturafornecedor.service;

import com.lojafloriculturafornecedor.dto.ItemDoPedidoDTO;
import com.lojafloriculturafornecedor.model.Pedido;
import com.lojafloriculturafornecedor.model.PedidoItem;
import com.lojafloriculturafornecedor.model.Produto;
import com.lojafloriculturafornecedor.repository.PedidoRepository;
import com.lojafloriculturafornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido realizarPedido(List<ItemDoPedidoDTO> itens) {

        if(itens == null)
            return null;

        List<PedidoItem> pedidoItens = toPedidoItem(itens);
        Pedido pedido = new Pedido(pedidoItens);
        pedido.setTempoDePreparo(itens.size());
        return pedidoRepository.save(pedido);
    }

    public Pedido getPedidoPorId(Long id) {
        return this.pedidoRepository.findById(id).orElse(new Pedido());
    }

    private List<PedidoItem> toPedidoItem(List<ItemDoPedidoDTO> itens) {

        List<Long> idsProdutos = itens
                .stream()
                .map(item -> item.getId())
                .collect(Collectors.toList());

        List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);

        List<PedidoItem> pedidoItens = itens
                .stream()
                .map(item -> {
                    Produto produto = produtosDoPedido
                            .stream()
                            .filter(p -> p.getId() == item.getId())
                            .findFirst().get();

                    PedidoItem pedidoItem = new PedidoItem();
                    pedidoItem.setProduto(produto);
                    pedidoItem.setQuantidade(item.getQuantidade());
                    return pedidoItem;
                })
                .collect(Collectors.toList());
        return pedidoItens;
    }

}


