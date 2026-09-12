package com.nisholas.staybook.infrastructure.persistence;

import com.nisholas.staybook.core.enums.AcomodacaoTipos;
import com.nisholas.staybook.core.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_acomodacoes")
public class AcomodacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String endereco;

    private String descricao;

    private String identificador;

    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "acomodacao_tipo")
    private AcomodacaoTipos acomodacaoTipos;

    private LocalDateTime dataDeCriacao;


}
