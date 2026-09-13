package com.nisholas.staybook.core.usecases;

import com.nisholas.staybook.core.entities.Acomodacao;
import com.nisholas.staybook.core.enums.AcomodacaoTipos;

import java.util.List;

public interface BuscarPorTipoDeAcomodacaoCase {

    List<Acomodacao> execute(AcomodacaoTipos type);

}
