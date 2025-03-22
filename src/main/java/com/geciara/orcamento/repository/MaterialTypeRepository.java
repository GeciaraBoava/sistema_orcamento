package com.geciara.orcamento.repository;

import com.geciara.orcamento.model.entitys.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialTypeRepository extends JpaRepository<MaterialType, Long> {

}

