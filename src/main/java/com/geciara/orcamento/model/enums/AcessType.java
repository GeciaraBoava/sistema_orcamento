package com.geciara.orcamento.entitys.enums;

public enum AcessType {
    ADMIN("Administrador", "Acesso completo ao sistema"),
    MANAGER("Gerente", "Pode gerenciar orçamentos e usuários"),
    BUDGET("Orçamentista", "Pode cadastrar e editar insumos e orçamentos"),
    VIEWER("Visualizador", "Acesso somente leitura");

    private final String name;
    private final String description;

    private AcessType(String name, String descricao) {
        this.name = name;
        this.description = descricao;
    }

    public String getName() { return name; }

    public String getDescription() { return description; }

}
