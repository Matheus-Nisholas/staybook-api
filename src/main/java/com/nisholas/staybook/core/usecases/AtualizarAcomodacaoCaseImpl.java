package com.nisholas.staybook.core.usecases;

import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.core.gateway.AcomodacaoGateway;

public class AtualizarAcomodacaoCaseImpl implements AtualizarAcomodacaoCase {

    private AcomodacaoGateway acomodacaoGateway;

    public AtualizarAcomodacaoCaseImpl(AcomodacaoGateway acomodacaoGateway) {
        this.acomodacaoGateway = acomodacaoGateway;
    }

    @Override
    public Acomodacao execute(Long id,  Acomodacao acomodacao) {
        return acomodacaoGateway.atualizar(id,  acomodacao);
    }
}
