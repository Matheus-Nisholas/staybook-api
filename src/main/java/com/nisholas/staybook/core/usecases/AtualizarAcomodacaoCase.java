package com.nisholas.staybook.core.usecases;

import com.nisholas.staybook.core.entities.Acomodacao;

public interface AtualizarAcomodacaoCase {

    Acomodacao execute(Long id, Acomodacao acomodacao);

}
