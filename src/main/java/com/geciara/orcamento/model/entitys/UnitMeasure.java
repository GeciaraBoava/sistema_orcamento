package com.geciara.orcamento.entitys;

public class UnitMeasure {
    private long id;
    private String descricao;

    public UnitMeasure() {}

    public UnitMeasure(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) { this.descricao = descricao; }

}
