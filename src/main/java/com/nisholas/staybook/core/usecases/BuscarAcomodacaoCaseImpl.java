package com.nisholas.staybook.core.usecases;

import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.core.gateway.AcomodacaoGateway;

public class BuscarAcomodacaoCaseImpl implements BuscarAcomodacaoCase{

    private final AcomodacaoGateway acomodacaoGateway;

    public BuscarAcomodacaoCaseImpl(AcomodacaoGateway acomodacaoGateway) {
        this.acomodacaoGateway = acomodacaoGateway;
    }

    @Override
    public Acomodacao execute(Long id) {
        return acomodacaoGateway.buscarPorId(id);
    }
}
