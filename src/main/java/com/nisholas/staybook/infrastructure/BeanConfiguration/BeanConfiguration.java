package com.nisholas.staybook.infrastructure.BeanConfiguration;

import com.nisholas.staybook.core.gateway.AcomodacaoGateway;
import com.nisholas.staybook.core.usecases.BuscarAcomodacaoCase;
import com.nisholas.staybook.core.usecases.BuscarAcomodacaoCaseImpl;
import com.nisholas.staybook.core.usecases.CriarAcomodacaoCase;
import com.nisholas.staybook.core.usecases.CriarAcomodacaoCaseImpl;
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
}

