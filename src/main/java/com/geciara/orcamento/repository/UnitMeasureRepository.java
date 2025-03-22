package com.geciara.orcamento.repository;

import com.geciara.orcamento.model.entitys.UnitMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitMeasureRepository extends JpaRepository<UnitMeasure, Long> {

}