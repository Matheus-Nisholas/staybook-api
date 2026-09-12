package com.nisholas.staybook.core.gateway;

import com.nisholas.staybook.core.entities.Acomodacao;

public interface AcomodacaoGateway {

    Acomodacao salvar(Acomodacao acomodacao);

    Acomodacao buscarPorId(Long id);

}
