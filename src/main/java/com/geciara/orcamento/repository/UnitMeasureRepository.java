package com.geciara.orcamento.repository;

import com.geciara.orcamento.model.entitys.UnitMeasureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitMeasureRepository extends JpaRepository<UnitMeasureEntity, Long> {

    Optional<UnitMeasureEntity> findByDescription(String description);
}