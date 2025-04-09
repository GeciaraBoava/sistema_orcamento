package com.geciara.orcamento.model.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@EqualsAndHashCode(callSuper = true)
public class ProductEntity extends BaseEntityAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "budget_id", nullable = false)
    private BudgetEntity budget;

    @Column(nullable = false, length = 1000, unique = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "unit_measure_id", nullable = false)
    private UnitMeasureEntity unitMeasure;

    @Column(name = "current_price")
    private BigDecimal referencePrice;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //remove preços se o material for deletado e vice-versa
    @JoinColumn(name = "material_id")
    private Set<MaterialEntity> materials = new HashSet<>();

}
