package com.geciara.orcamento.model.services;

import com.geciara.orcamento.model.entitys.Material;
import com.geciara.orcamento.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<Material, Long>{

    public CustomerService(CustomerRepository customerRepository) {
        super(customerRepository);
    }

}
