package com.geciara.orcamento.service;

import com.geciara.orcamento.dto.CustomerRequestDTO;
import com.geciara.orcamento.dto.CustomerResponseDTO;
import com.geciara.orcamento.dto.CustomerUpdateRequestDTO;
import com.geciara.orcamento.exceptions.ItemNotFoundException;
import com.geciara.orcamento.mapper.CustomerMapper;
import com.geciara.orcamento.model.entitys.CustomerEntity;
import com.geciara.orcamento.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerResponseDTO save(CustomerRequestDTO dto) {
        CustomerEntity customer = customerMapper.toCustomerEntity(dto);
        customer = customerRepository.save(customer);
        return customerMapper.toResponseDTO(customer);
    }

    public List<CustomerResponseDTO> listAll() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponseDTO)
                .toList();
    }

    public CustomerResponseDTO findById(Long id) {
        CustomerEntity customer = customerRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        return customerMapper.toResponseDTO(customer);
    }

    public CustomerResponseDTO update(Long id, CustomerUpdateRequestDTO dto) {
        CustomerEntity customer = customerRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        CustomerEntity updatedCustomer = customerMapper.updateEntityFromDTO(dto, customer);
        customerRepository.save(updatedCustomer);
        return customerMapper.toResponseDTO(updatedCustomer);
    }

    public void delete(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new ItemNotFoundException();
        }
        customerRepository.deleteById(id);
    }

}
