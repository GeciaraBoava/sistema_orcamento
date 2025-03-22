package com.geciara.orcamento.model.services;

import com.geciara.orcamento.model.entitys.Material;
import com.geciara.orcamento.repository.CustomerRepository;
import com.geciara.orcamento.repository.SupplierRepository;
import org.springframework.stereotype.Service;

@Service
public class SupplierService extends BaseService<Material, Long>{

    public SupplierService(SupplierRepository supplierRepository) {
        super(supplierRepository);
    }

}
