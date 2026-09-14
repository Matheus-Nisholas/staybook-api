package com.nisholas.staybook.core.usecases;

import com.nisholas.staybook.core.Exception.DuplicateEnderecoException;
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
                "STAY-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase(),
                acomodacao.preco(),
                Status.DISPONIVEL,
                acomodacao.acomodacaoTipos(),
                LocalDateTime.now()
        );

        if (acomodacaoGateway.enderecoEmUso(acomodacao.endereco())) {
            throw new DuplicateEnderecoException("O endereço:(" + acomodacao.endereco() + ") já está em uso");
        }
            return acomodacaoGateway.salvar(novaAcomodacao);

    }
}
