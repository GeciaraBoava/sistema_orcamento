package com.geciara.orcamento.model.types;

public enum AcessType {
    ADMIN("Administrador", "Acesso completo ao sistema"),
    GERENTE("Gerente", "Pode gerenciar orçamentos e usuários"),
    ORCAMENTOS("Orçamentista", "Pode cadastrar e editar insumos e orçamentos"),
    VISUALIZADOR("Visualizador", "Acesso somente leitura");

    private final String name;
    private final String descricao;

    private AcessType(String name, String descricao) {
        this.name = name;
        this.descricao = descricao;
    }

    public String getName() { return name; }

    public String getDescricao() { return descricao; }

}
