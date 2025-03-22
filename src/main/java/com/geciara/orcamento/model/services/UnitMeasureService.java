package com.geciara.orcamento.model.services;

import com.geciara.orcamento.model.entitys.UnitMeasure;
import com.geciara.orcamento.repository.UnitMeasureRepository;
import org.springframework.stereotype.Service;

@Service
public class UnitMeasureService extends BaseServiceImpl<UnitMeasure, UnitMeasureRepository> {

    public UnitMeasureService(UnitMeasureRepository unitMeasureRepository) {
        super(unitMeasureRepository);
    }

}
