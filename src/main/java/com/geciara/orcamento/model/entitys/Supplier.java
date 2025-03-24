package com.geciara.orcamento.model.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "supplier")
public class Supplier extends GenericEntitys {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    @SequenceGenerator(name = "supplier_seq", sequenceName = "supplier_seq", allocationSize = 1)
    private Long id;

    public Supplier() {
        super();
    }

    public Long getId() { return id; }
}
