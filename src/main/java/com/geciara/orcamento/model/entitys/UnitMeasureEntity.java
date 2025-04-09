package com.geciara.orcamento.model.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "unit_measure")
@EqualsAndHashCode(callSuper = true)
public class UnitMeasureEntity extends BaseEntityAudit{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_measure_seq")
    @SequenceGenerator(name = "unit_measure_seq", sequenceName = "unit_measure_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 50)
    private String description;

    @Column(nullable = false)
    private boolean isActive;

}
