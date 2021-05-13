package com.lojafloriculturafornecedor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lojafloriculturafornecedor.model.infomacoesFornecedor;

@Repository
public interface InformacoesRepository extends CrudRepository < infomacoesFornecedor, Long>  {

    infomacoesFornecedor findByEstado(String estado);
}
