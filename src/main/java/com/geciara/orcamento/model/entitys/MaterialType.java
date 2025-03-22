package com.geciara.orcamento.model.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "material_type")
public class MaterialType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_type_seq")
    @SequenceGenerator(name = "material_type_seq", sequenceName = "material_type_seq", allocationSize = 1)
    private Long id;
    private String descricao;
    private boolean active;

    public MaterialType() {}

    public MaterialType(String descricao) {
        this.descricao = descricao;
        this.active = true;
    }

    public Long getId() { return id; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public boolean getActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

}
