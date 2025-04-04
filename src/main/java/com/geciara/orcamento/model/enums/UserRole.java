package com.geciara.orcamento.model.enums;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum UserRole {
    ADMIN("Administrador", "Acesso completo ao sistema"),
    MANAGER("Gerente", "Pode gerenciar orçamentos e usuários"),
    BUDGET("Orçamentista", "Pode cadastrar e editar insumos e orçamentos");

    private final String role;
    private final String description;

    UserRole(String role, String description) {
        this.role = role;
        this.description = description;
    }

    public GrantedAuthority getAuthority() {
        return new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_" + this.name()); //name retorna o nome da role, ex.: ADMIN
    }
}

