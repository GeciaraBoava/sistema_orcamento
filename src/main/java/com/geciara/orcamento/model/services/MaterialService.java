package com.geciara.orcamento.model.services;

import com.geciara.orcamento.model.entitys.Material;
import com.geciara.orcamento.model.exceptions.InvalidPriceException;
import com.geciara.orcamento.model.exceptions.ItemNotFoundException;
import com.geciara.orcamento.repository.MaterialRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class MaterialService extends GenericServiceImpl<Material, MaterialRepository> {

    public MaterialService(MaterialRepository materialRepository) {
        super(materialRepository);
    }

    @Transactional
    public void updateMaterialPrice(Long id, BigDecimal newPrice) {

        if (newPrice.signum() == -1) { throw new InvalidPriceException("O preço não pode ser negativo"); }

        Material material = repository.findById(id)
                .orElseThrow(ItemNotFoundException::new);

        material.setPrice(newPrice);
        material.setUpdateDate(LocalDateTime.now());
    }

}
