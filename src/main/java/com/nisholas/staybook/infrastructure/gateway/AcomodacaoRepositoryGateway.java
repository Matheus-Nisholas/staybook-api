package com.nisholas.staybook.infrastructure.gateway;

import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.core.gateway.AcomodacaoGateway;
import com.nisholas.staybook.infrastructure.Mapper.AcomodacaoEntityMapper;
import com.nisholas.staybook.infrastructure.persistence.AcomodacaoEntity;
import com.nisholas.staybook.infrastructure.persistence.AcomodacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AcomodacaoRepositoryGateway implements AcomodacaoGateway {

    private final AcomodacaoRepository acomodacaoRepository;

    private final AcomodacaoEntityMapper acomodacaoEntityMapper;

    @Override
    public Acomodacao salvar(Acomodacao acomodacao) {
        AcomodacaoEntity entity = acomodacaoEntityMapper.toEntity(acomodacao);
        AcomodacaoEntity novaEntity = acomodacaoRepository.save(entity);
        return acomodacaoEntityMapper.toDomain(novaEntity);
    }

    @Override
    public Acomodacao buscarPorId(Long id) {
        return null;
    }
}
