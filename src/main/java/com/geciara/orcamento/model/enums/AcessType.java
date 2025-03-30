package com.geciara.orcamento.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AcessType {
    ADMIN("Administrador", "Acesso completo ao sistema"),
    MANAGER("Gerente", "Pode gerenciar orçamentos e usuários"),
    BUDGET("Orçamentista", "Pode cadastrar e editar insumos e orçamentos"),
    VIEWER("Visualizador", "Acesso somente leitura");

    private final String name;
    private final String description;

}
