package com.nisholas.staybook.core.gateway;

import com.nisholas.staybook.core.entities.Acomodacao;

import java.util.List;

public interface AcomodacaoGateway {

    Acomodacao salvar(Acomodacao acomodacao);

    Acomodacao buscarPorId(Long id);

    List<Acomodacao> buscarTodas();

}
