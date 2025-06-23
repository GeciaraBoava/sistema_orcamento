package com.geciara.orcamento.model.entitys.budgetDetails;

import java.math.BigDecimal;
import java.util.List;

public class FixedExpensesBDI {

    private BigDecimal percentageOnBudgetCost;

    private BigDecimal percentageOnFixedExpenses;
    private List<MonthlyFixedExpense> monthlyFixedExpense;
    private BigDecimal valueTotalMonthlyFixedExpense;

    private BigDecimal profitMargin;
    private BigDecimal risk;
}
