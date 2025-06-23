package com.geciara.orcamento.dto;

import com.geciara.orcamento.model.entitys.budgetDetails.Freight;
import com.geciara.orcamento.model.entitys.budgetDetails.Installation;
import com.geciara.orcamento.model.entitys.budgetDetails.Management;
import com.geciara.orcamento.model.entitys.budgetDetails.Taxes;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BudgetResponseDTO {

    private Long id;
    private LocalDate date;
    private LocalDate dateReference;
    private CustomerResponseDTO customer;
    private List<ProductResponseDTO> products;
    private Taxes taxes;
    private Freight freight;
    private Installation installation;
    private Management management;
    private BigDecimal fixedExpenses;
    private BigDecimal total;

}
