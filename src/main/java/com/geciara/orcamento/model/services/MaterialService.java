package com.geciara.orcamento.model.services;

import com.geciara.orcamento.model.entitys.Material;
import com.geciara.orcamento.repository.MaterialRepository;
import org.springframework.stereotype.Service;


@Service
public class MaterialService extends GenericServiceImpl<Material, MaterialRepository> {

    public MaterialService(MaterialRepository materialRepository) {
        super(materialRepository);
    }




}
