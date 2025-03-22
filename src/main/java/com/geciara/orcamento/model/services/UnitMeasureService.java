package com.geciara.orcamento.model.services;

import com.geciara.orcamento.model.entitys.Material;
import com.geciara.orcamento.repository.CustomerRepository;
import com.geciara.orcamento.repository.UnitMeasureRepository;
import org.springframework.stereotype.Service;

@Service
public class UnitMeasureService extends BaseService<Material, Long>{

    public UnitMeasureService(UnitMeasureRepository unitMeasureRepository) {
        super(unitMeasureRepository);
    }

}
