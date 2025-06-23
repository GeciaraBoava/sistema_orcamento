package com.geciara.orcamento.model.entitys.materialDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geciara.orcamento.model.entitys.Material;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
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
    private Material material;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime registeredAt;
}
