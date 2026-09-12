package com.nisholas.staybook.infrastructure.DTO;

import com.nisholas.staybook.core.enums.AcomodacaoTipos;
import com.nisholas.staybook.core.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AcomodacaoDTO(Long id,
                            String nome,
                            String endereco,
                            String descricao,
                            String identificador,
                            BigDecimal preco,
                            Status status,
                            AcomodacaoTipos acomodacaoTipos,
                            LocalDateTime dataDeCriacao) {
}
