package com.nisholas.staybook.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcomodacaoRepository extends JpaRepository<AcomodacaoEntity, Long> {
}
