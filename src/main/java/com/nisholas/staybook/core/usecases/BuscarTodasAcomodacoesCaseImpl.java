package com.nisholas.staybook.core.usecases;

import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.core.gateway.AcomodacaoGateway;

import java.util.List;

public class BuscarTodasAcomodacoesCaseImpl implements BuscarTodasAcomodacoesCase {

    private final AcomodacaoGateway acomodacaoGateway;

    public BuscarTodasAcomodacoesCaseImpl(AcomodacaoGateway acomodacaoGateway) {
        this.acomodacaoGateway = acomodacaoGateway;
    }

    @Override
    public List<Acomodacao> excute() {
        return acomodacaoGateway.buscarTodas();
    }

}
