package com.geciara.orcamento.dto;

import com.geciara.orcamento.model.entitys.budgetDetails.Freight;
import com.geciara.orcamento.model.entitys.budgetDetails.Installation;
import com.geciara.orcamento.model.entitys.budgetDetails.Management;
import com.geciara.orcamento.model.entitys.budgetDetails.Taxes;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BudgetRequestDTO {

    @NotNull(message = "Data é obrigatória")
    private LocalDate date;

    @NotNull(message = "Data de referência é obrigatória")
    private LocalDate dateReference;

    @NotNull(message = "Cliente é obrigatório")
    private Long customerId;

    @NotEmpty(message = "Produto é obrigatório")
    private List<Long> productIds;

    private Taxes taxes;
    private Freight freight;
    private Installation installation;
    private Management management;
    private BigDecimal fixedExpenses;

}
