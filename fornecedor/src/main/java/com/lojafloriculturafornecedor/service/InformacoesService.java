package com.lojafloriculturafornecedor.service;

import com.lojafloriculturafornecedor.model.infomacoesFornecedor;
import com.lojafloriculturafornecedor.repository.InformacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformacoesService {

    @Autowired
    private InformacoesRepository informacoesRepository;

    public infomacoesFornecedor getInformacoesPorEstado(String estado) {
        return informacoesRepository.findByEstado(estado);

    }
}
