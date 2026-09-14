package com.nisholas.staybook.core.gateway;

import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.core.enums.AcomodacaoTipos;

import java.util.List;

public interface AcomodacaoGateway {

    Acomodacao salvar(Acomodacao acomodacao);

    boolean enderecoEmUso(String endereco);

    Acomodacao buscarPorId(Long id);

    List<Acomodacao> buscarTodas();

    Acomodacao excluir(Long id);

    List<Acomodacao> buscarPorTipo(AcomodacaoTipos type);

    Acomodacao atualizar(Long id, Acomodacao acomodacao);

}
