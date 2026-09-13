package com.nisholas.staybook.core.usecases;

import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.core.enums.Status;
import com.nisholas.staybook.core.gateway.AcomodacaoGateway;

import java.time.LocalDateTime;
import java.util.UUID;

public class CriarAcomodacaoCaseImpl implements CriarAcomodacaoCase{

    private final AcomodacaoGateway acomodacaoGateway;

    public CriarAcomodacaoCaseImpl(AcomodacaoGateway acomodacaoGateway) {
        this.acomodacaoGateway = acomodacaoGateway;
    }

    @Override
    public Acomodacao execute(Acomodacao acomodacao) {
        Acomodacao novaAcomodacao = new Acomodacao(
                null,
                acomodacao.nome(),
                acomodacao.endereco(),
                acomodacao.descricao(),
                UUID.randomUUID().toString(),
                acomodacao.preco(),
                Status.DISPONIVEL,
                acomodacao.acomodacaoTipos(),
                LocalDateTime.now()
        );
        return acomodacaoGateway.salvar(novaAcomodacao);
    }
}
