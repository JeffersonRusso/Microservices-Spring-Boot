package com.lojafloriculturafornecedor.repository;

import com.lojafloriculturafornecedor.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    List<Produto> findByEstado(String estado);

    List<Produto> findByIdIn(List<Long> ids);
}
