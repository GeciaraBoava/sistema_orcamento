package com.geciara.orcamento.repository;

import com.geciara.orcamento.model.entitys.MaterialTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialTypeRepository extends JpaRepository<MaterialTypeEntity, Long> {

    Optional<MaterialTypeEntity> findByDescription(String description);
}

