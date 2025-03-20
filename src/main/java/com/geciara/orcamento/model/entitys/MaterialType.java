package com.geciara.orcamento.entitys;

public class MaterialType {
    private long id;
    private String descricao;
    private boolean active;

    public MaterialType() {}

    public MaterialType(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.active = true;
    }

    public long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public boolean getActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

}
