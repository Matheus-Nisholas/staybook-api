package com.nisholas.staybook.core.usecases;

import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.core.enums.AcomodacaoTipos;
import com.nisholas.staybook.core.gateway.AcomodacaoGateway;

import java.util.List;

public class BuscarPorTipoDeAcomodacaoCaseImpl implements BuscarPorTipoDeAcomodacaoCase {

    private AcomodacaoGateway acomodacaoGateway;

    public BuscarPorTipoDeAcomodacaoCaseImpl(AcomodacaoGateway acomodacaoGateway) {
        this.acomodacaoGateway = acomodacaoGateway;
    }

    public List<Acomodacao> execute(AcomodacaoTipos type){
        return acomodacaoGateway.buscarPorTipo(type);
    }
}
