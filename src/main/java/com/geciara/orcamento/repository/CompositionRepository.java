package com.geciara.orcamento.repository;

import com.geciara.orcamento.model.entitys.Composition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionRepository extends JpaRepository<Composition, Long> {

}
