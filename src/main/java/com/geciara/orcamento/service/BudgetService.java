package com.geciara.orcamento.service;

import com.geciara.orcamento.dto.BudgetRequestDTO;
import com.geciara.orcamento.dto.BudgetResponseDTO;
import com.geciara.orcamento.dto.BudgetUpdateDTO;
import com.geciara.orcamento.exceptions.ItemNotFoundException;
import com.geciara.orcamento.mapper.BudgetMapper;
import com.geciara.orcamento.model.entitys.Budget;
import com.geciara.orcamento.model.entitys.Customer;
import com.geciara.orcamento.model.entitys.Product;
import com.geciara.orcamento.repository.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final BudgetMapper budgetMapper;
    private final CustomerService customerService;
    private final ProductService productService;

    public BudgetService(BudgetRepository budgetRepository,
                         BudgetMapper budgetMapper,
                         CustomerService customerService,
                         ProductService productService
    ) {
        this.budgetRepository = budgetRepository;
        this.budgetMapper = budgetMapper;
        this.customerService = customerService;
        this.productService = productService;
    }

    public BudgetResponseDTO save(BudgetRequestDTO dto) {
        Customer customer = customerService.findCustomerById(dto.getCustomerId());
        List<Product> productList = dto.getProductIds()
                .stream()
                .map(productService::findProductById)
                .toList();

        Budget budget = budgetMapper.toEntity(dto, customer, productList);
        budget = budgetRepository.save(budget);

        return budgetMapper.toResponseDTO(budget);
    }

    public List<BudgetResponseDTO> listAll() {
        return budgetRepository.findAll()
                .stream()
                .map(budgetMapper::toResponseDTO)
                .toList();
    }

    public BudgetResponseDTO findById(Long id) {
        Budget budget = budgetRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        return budgetMapper.toResponseDTO(budget);
    }

    public BudgetResponseDTO update(Long id, BudgetUpdateDTO dto) {
        Customer customer = customerService.findCustomerById(dto.getCustomerId());
        List<Product> productList = dto.getProductIds()
                .stream()
                .map(productService::findProductById)
                .toList();

        Budget budget = budgetRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        Budget updatedBudget = budgetMapper.updateFromDTO(dto, budget, customer, productList);
        budgetRepository.save(updatedBudget);
        return budgetMapper.toResponseDTO(updatedBudget);
    }

    public void delete(Long id) {
        if (!budgetRepository.existsById(id)) {
            throw new ItemNotFoundException();
        }
        budgetRepository.deleteById(id);
    }

}
