package com.nisholas.staybook.infrastructure.Mapper;

import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.infrastructure.DTO.AcomodacaoDTO;
import org.springframework.stereotype.Component;

@Component
public class AcomodacaoMapper {

    public AcomodacaoDTO ToDTO(Acomodacao acomodacao) {
        return new AcomodacaoDTO(
                acomodacao.id(),
                acomodacao.nome(),
                acomodacao.endereco(),
                acomodacao.descricao(),
                acomodacao.identificador(),
                acomodacao.preco(),
                acomodacao.status(),
                acomodacao.acomodacaoTipos(),
                acomodacao.dataDeCriacao()
        );
    }

    public Acomodacao ToDomain(AcomodacaoDTO acomodacaoDTO) {
        return new Acomodacao(
                acomodacaoDTO.id(),
                acomodacaoDTO.nome(),
                acomodacaoDTO.endereco(),
                acomodacaoDTO.descricao(),
                acomodacaoDTO.identificador(),
                acomodacaoDTO.preco(),
                acomodacaoDTO.status(),
                acomodacaoDTO.acomodacaoTipos(),
                acomodacaoDTO.dataDeCriacao()
        );
    }
}
