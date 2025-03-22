package com.geciara.orcamento.model.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "unit_measure")
public class UnitMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_measure_seq")
    @SequenceGenerator(name = "unit_measure_seq", sequenceName = "unit_measure_seq", allocationSize = 1)
    private Long id;

    private String descricao;

    public UnitMeasure() {}

    public UnitMeasure(String descricao) {
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) { this.descricao = descricao; }

}
