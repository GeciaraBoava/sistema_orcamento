package com.geciara.orcamento.services;

import com.geciara.orcamento.model.entitys.Supplier;
import com.geciara.orcamento.repository.SupplierRepository;
import org.springframework.stereotype.Service;

@Service
public class SupplierService extends GenericServiceImpl<Supplier, SupplierRepository> {

    public SupplierService(SupplierRepository supplierRepository) {
        super(supplierRepository);
    }

}
