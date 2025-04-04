package com.geciara.orcamento.controller;

import com.geciara.orcamento.dto.CustomerRequestDTO;
import com.geciara.orcamento.dto.CustomerResponseDTO;
import com.geciara.orcamento.dto.CustomerUpdateRequestDTO;
import com.geciara.orcamento.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Validated
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> listAll() {
        return ResponseEntity.ok(customerService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> save(@RequestBody @Valid CustomerRequestDTO entity) {
        CustomerResponseDTO savedEntity = customerService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> update(@PathVariable Long id, @RequestBody @Valid CustomerUpdateRequestDTO entity) {
        CustomerResponseDTO updatedEntity = customerService.update(id, entity);
        return ResponseEntity.ok(updatedEntity);

    }


}