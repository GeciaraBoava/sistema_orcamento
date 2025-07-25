package com.geciara.orcamento.model.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "unit_measure")
public class UnitMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_measure_seq")
    @SequenceGenerator(name = "unit_measure_seq", sequenceName = "unit_measure_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 50)
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(nullable = false, updatable = false)
    private LocalDateTime registeredAt;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean isActive;


    public UnitMeasure(String descricao) {
        this.description = descricao;
    }

}
