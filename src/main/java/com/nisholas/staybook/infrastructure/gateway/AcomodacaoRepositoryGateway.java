package com.nisholas.staybook.infrastructure.gateway;

import com.nisholas.staybook.core.Exception.NotFoundAcomodaçaoException;
import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.core.enums.AcomodacaoTipos;
import com.nisholas.staybook.core.enums.Status;
import com.nisholas.staybook.core.gateway.AcomodacaoGateway;
import com.nisholas.staybook.infrastructure.Mapper.AcomodacaoEntityMapper;
import com.nisholas.staybook.infrastructure.persistence.AcomodacaoEntity;
import com.nisholas.staybook.infrastructure.persistence.AcomodacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    public boolean enderecoEmUso(String endereco) {
        return acomodacaoRepository.findAll()
                .stream()
                .anyMatch(acomodacao -> acomodacao.getEndereco()
                        .equalsIgnoreCase(endereco));
    }

    @Override
    public Acomodacao buscarPorId(Long id) {
        return acomodacaoRepository
                .findById(id)
                .map(acomodacaoEntityMapper::toDomain)
                .orElseThrow(() -> new NotFoundAcomodaçaoException("A acomodação não foi encontrada ou não existe!"));

    }

    @Override
    public List<Acomodacao> buscarTodas() {
        return acomodacaoRepository.findAll()
                .stream()
                .map(acomodacaoEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Acomodacao excluir(Long id) {
        Acomodacao acomodacao = buscarPorId(id);
        acomodacaoRepository.deleteById(id);
        return acomodacao;
    }

    @Override
    public List<Acomodacao> buscarPorTipo(AcomodacaoTipos type) {
        return acomodacaoRepository
                .findByAcomodacaoTipos(type)
                .stream()
                .map(acomodacaoEntityMapper::toDomain)
                .toList();

    }

    @Override
    public Acomodacao atualizar(Long id, Acomodacao acomodacao) {
        Acomodacao acomodacaoExistente = buscarPorId(id);

        Acomodacao acomodacaoAtualizada = new Acomodacao(
                acomodacaoExistente.id(),
                acomodacao.nome(),
                acomodacao.endereco(),
                acomodacao.descricao(),
                acomodacaoExistente.identificador(),
                acomodacao.preco(),
                acomodacaoExistente.status(),
                acomodacao.acomodacaoTipos(),
                acomodacaoExistente.dataDeCriacao());

                return salvar(acomodacaoAtualizada);

    }


}
