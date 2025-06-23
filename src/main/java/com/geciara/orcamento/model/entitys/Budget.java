package com.geciara.orcamento.model.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geciara.orcamento.model.entitys.budgetDetails.Freight;
import com.geciara.orcamento.model.entitys.budgetDetails.Installation;
import com.geciara.orcamento.model.entitys.budgetDetails.Management;
import com.geciara.orcamento.model.entitys.budgetDetails.Taxes;
import com.geciara.orcamento.model.enums.BudgetStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    @SequenceGenerator(name = "supplier_seq", sequenceName = "supplier_seq", allocationSize = 1)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDate date;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDate dateReference;

    @Column(nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private List<Product> product;

    private Taxes taxes;
    private Freight freight;
    private Installation installation;
    private Management management;

    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false)
    private BigDecimal FixedExpenses;

    @Column(nullable = false)
    private boolean isActive;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(nullable = false, updatable = false)
    private LocalDateTime registeredAt;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime updatedAt;

    private BudgetStatus status;
}
