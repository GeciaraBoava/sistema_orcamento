package com.geciara.orcamento.controller;

import com.geciara.orcamento.model.entitys.Material;
import com.geciara.orcamento.model.services.MaterialService;

public class MaterialController extends GenericController<Material, MaterialService> {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        super(materialService);
        this.materialService = materialService;
    }

}
