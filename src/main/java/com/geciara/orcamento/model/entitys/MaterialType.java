package com.geciara.orcamento.model.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "material_type")
public class MaterialType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_type_seq")
    @SequenceGenerator(name = "material_type_seq", sequenceName = "material_type_seq", allocationSize = 1)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String description;

    @Column(nullable = false)
    private boolean isActive;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false, updatable = false)
    protected LocalDateTime registeredAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDateTime updatedAt;


    public MaterialType(String descricao) {
        this.description = descricao;
    }
}
