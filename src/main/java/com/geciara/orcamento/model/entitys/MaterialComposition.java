package com.geciara.orcamento.model.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "material_composition")
public class MaterialComposition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_composition_seq")
    @SequenceGenerator(name = "material_composition_seq", sequenceName = "material_composition_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "composition_id")
    private Composition composition;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @Column(nullable = false)
    private BigDecimal quantity;
}
