package com.geciara.orcamento.controller;

import com.geciara.orcamento.dto.*;
import com.geciara.orcamento.service.BudgetService;
import com.geciara.orcamento.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Orçamentos", description = "Gerenciamento de orçamentos do sistema")
@RestController
@RequestMapping("/api/budgets")
@Validated
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping
    public ResponseEntity<List<BudgetResponseDTO>> listAll() {
        return ResponseEntity.ok(budgetService.listAll());
    }

    @Operation(summary = "Buscar orçamento por ID", description = "Recupera um orçamento pelo seu ID")
    @ApiResponse(responseCode = "200", description = "Orçamento encontrado")
    @ApiResponse(responseCode = "403", description = "Acesso negado")
    @ApiResponse(responseCode = "404", description = "Orçamento não encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<BudgetResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(budgetService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BudgetResponseDTO> save(@RequestBody @Valid BudgetRequestDTO entity) {
        BudgetResponseDTO savedEntity = budgetService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        budgetService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BudgetResponseDTO> update(@PathVariable Long id,@RequestBody @Valid BudgetUpdateDTO entity) {
        BudgetResponseDTO updatedEntity = budgetService.update(id, entity);
        return ResponseEntity.ok(updatedEntity);

    }


}