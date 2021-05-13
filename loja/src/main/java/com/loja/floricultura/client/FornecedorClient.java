package com.loja.floricultura.client;

import com.loja.floricultura.Dto.InfoFornecedorDto;
import com.loja.floricultura.Dto.InfoPedidoDto;
import com.loja.floricultura.Dto.ItemDaCompraDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDto getInforPorEstado(@PathVariable String estado);

    @RequestMapping(method = RequestMethod.POST, value="/pedido")
    InfoPedidoDto realizaPedido(List<ItemDaCompraDto> itens);
}
