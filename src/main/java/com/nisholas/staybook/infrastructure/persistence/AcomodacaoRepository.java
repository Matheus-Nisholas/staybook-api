package com.nisholas.staybook.infrastructure.persistence;

import com.nisholas.staybook.core.enums.AcomodacaoTipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcomodacaoRepository extends JpaRepository<AcomodacaoEntity, Long> {

    List<AcomodacaoEntity> findByAcomodacaoTipos(AcomodacaoTipos acomodacaoTipos);

}
