package com.geciara.orcamento.model.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "price_history")
public class PriceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_history_seq")
    @SequenceGenerator(name = "price_history_seq", sequenceName = "price_history_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private Long materialId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime registeredAt;

    public PriceHistory(
           Long materialId, BigDecimal price) {

        this.materialId = materialId;
        this.price = price;

    }
}
