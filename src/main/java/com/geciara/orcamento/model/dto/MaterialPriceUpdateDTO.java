package com.geciara.orcamento.model.dto;

import java.math.BigDecimal;

public class MaterialPriceUpdateDTO {
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
