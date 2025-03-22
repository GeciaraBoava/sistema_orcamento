package com.geciara.orcamento.repository;

import com.geciara.orcamento.model.entitys.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Material, Long> {

}


