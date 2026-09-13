package com.nisholas.staybook.core.usecases;

import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.core.gateway.AcomodacaoGateway;

public class DeletarAcomodacaoCaseImpl implements DeletarAcomodacaoCase {

    private AcomodacaoGateway acomodacaoGateway;

    public DeletarAcomodacaoCaseImpl(AcomodacaoGateway acomodacaoGateway) {
        this.acomodacaoGateway = acomodacaoGateway;
    }

    @Override
    public Acomodacao execute(Long id) {
        return acomodacaoGateway.excluir(id);
    }
}
