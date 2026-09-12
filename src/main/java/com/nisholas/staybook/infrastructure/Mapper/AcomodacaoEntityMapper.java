package com.nisholas.staybook.infrastructure.Mapper;

import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.infrastructure.persistence.AcomodacaoEntity;
import org.springframework.stereotype.Component;

@Component
public class AcomodacaoEntityMapper {

    public AcomodacaoEntity toEntity(Acomodacao acomodacao){
        return  new AcomodacaoEntity(
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

    public Acomodacao toDomain(AcomodacaoEntity acomodacaoEntity){
        return  new Acomodacao(
                acomodacaoEntity.getId(),
                acomodacaoEntity.getNome(),
                acomodacaoEntity.getEndereco(),
                acomodacaoEntity.getDescricao(),
                acomodacaoEntity.getIdentificador(),
                acomodacaoEntity.getPreco(),
                acomodacaoEntity.getStatus(),
                acomodacaoEntity.getAcomodacaoTipos(),
                acomodacaoEntity.getDataDeCriacao()
        );
    }

}
