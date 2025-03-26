package com.geciara.orcamento.controller;

import com.geciara.orcamento.model.entitys.Material;
import com.geciara.orcamento.services.MaterialService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/materiais")  // Define o caminho base para os endpoints
@Tag(name = "Materiais", description = "Operações relacionadas a materiais")
public class MaterialController extends GenericController<Material, MaterialService> {

    public MaterialController(MaterialService materialService) {
        super(materialService);
    }

}
