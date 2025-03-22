package com.geciara.orcamento.model.services;

import com.geciara.orcamento.model.entitys.Customer;
import com.geciara.orcamento.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseServiceImpl<Customer, CustomerRepository> {

    public CustomerService(CustomerRepository customerRepository) {
        super(customerRepository);
    }

}
