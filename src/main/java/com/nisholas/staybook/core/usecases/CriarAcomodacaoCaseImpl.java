package com.nisholas.staybook.core.usecases;

import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.core.gateway.AcomodacaoGateway;

public class CriarAcomodacaoCaseImpl implements CriarAcomodacaoCase{

    private final AcomodacaoGateway acomodacaoGateway;

    public CriarAcomodacaoCaseImpl(AcomodacaoGateway acomodacaoGateway) {
        this.acomodacaoGateway = acomodacaoGateway;
    }

    @Override
    public Acomodacao execute(Acomodacao acomodacao) {
        return acomodacaoGateway.salvar(acomodacao);
    }
}
