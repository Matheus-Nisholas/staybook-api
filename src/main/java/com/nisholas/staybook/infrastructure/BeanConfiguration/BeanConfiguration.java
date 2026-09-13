package com.nisholas.staybook.infrastructure.BeanConfiguration;

import com.nisholas.staybook.core.gateway.AcomodacaoGateway;
import com.nisholas.staybook.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarAcomodacaoCase criarAcomodacaoCase(
            AcomodacaoGateway acomodacaoGateway
    ) {
        return new CriarAcomodacaoCaseImpl(acomodacaoGateway);
    }

    @Bean
    public BuscarAcomodacaoCase buscarAcomodacaoCase(
            AcomodacaoGateway acomodacaoGateway
    ) {
        return new BuscarAcomodacaoCaseImpl(acomodacaoGateway);
    }

    @Bean
    public BuscarTodasAcomodacoesCase buscarTodasAcomodacoes(
            AcomodacaoGateway acomodacaoGateway
    ) {
        return new BuscarTodasAcomodacoesCaseImpl(acomodacaoGateway);
    }

    @Bean
    public DeletarAcomodacaoCase deletarAcomodacaoCase(
            AcomodacaoGateway acomodacaoGateway
    ) {
        return new DeletarAcomodacaoCaseImpl(acomodacaoGateway);
    }

    @Bean
    public BuscarPorTipoDeAcomodacaoCase buscarPorTipoDeAcomodacaoCase(
            AcomodacaoGateway acomodacaoGateway
    ) {
        return new BuscarPorTipoDeAcomodacaoCaseImpl(acomodacaoGateway);
    }

    @Bean
    public AtualizarAcomodacaoCase atualizarAcomodacaoCase(
            AcomodacaoGateway acomodacaoGateway
    ) {
        return new AtualizarAcomodacaoCaseImpl(acomodacaoGateway);
    }

}

