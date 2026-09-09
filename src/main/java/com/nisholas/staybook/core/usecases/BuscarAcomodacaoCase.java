package com.nisholas.staybook.core.usecases;

import com.nisholas.staybook.core.entities.Acomodacao;

public interface BuscarAcomodacaoCase {

    Acomodacao execute(Long id);

}
