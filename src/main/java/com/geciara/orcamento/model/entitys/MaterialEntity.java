package com.geciara.orcamento.model.entitys;

import com.geciara.orcamento.exceptions.ItemNotFoundException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "material")
public class MaterialEntity extends BaseEntityAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_seq")
    @SequenceGenerator(name = "material_seq", sequenceName = "material_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "material_type_id", nullable = false)
    private MaterialTypeEntity materialType;

    @ManyToOne
    @JoinColumn(name = "unit_measure_id", nullable = false)
    private UnitMeasureEntity unitMeasure;

    @Column(name = "current_price")
    private BigDecimal currentPrice;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //remove preços se o material for deletado e vice-versa
    @JoinColumn(name = "material_id")
    private Set<PriceHistoryEntity> priceHistories = new HashSet<>();

    @Column(nullable = false)
    private boolean isActive;

    public MaterialEntity(String description,
                          MaterialTypeEntity materialType,
                          UnitMeasureEntity unitMeasure,
                          BigDecimal currentPrice) {
        this.description = description;
        this.materialType = materialType;
        this.unitMeasure = unitMeasure;
        this.currentPrice = currentPrice;
    }

    //buscar preço conforme data-base do orçamento
    public BigDecimal getPriceByBaseData(LocalDate baseDate){
        LocalDateTime baseDateTime = baseDate.atTime(LocalTime.MAX);

        //busca o preço criado até a data base
        Optional<PriceHistoryEntity> priceUpToBaseDate = priceHistories.stream()
                .filter(ph -> !ph.getRegisteredAt().isAfter(baseDateTime))
                .max(Comparator.comparing(PriceHistoryEntity::getRegisteredAt));

        if(priceUpToBaseDate.isPresent()) {
            return priceUpToBaseDate.get().getPrice();
        } else {
            return  priceHistories.stream()
                    .min(Comparator.comparingLong(
                            ph -> ChronoUnit.DAYS.between(baseDateTime.toLocalDate(),
                                    ph.getRegisteredAt().toLocalDate())))
                    .map(PriceHistoryEntity::getPrice)
                    .orElseThrow(() -> new ItemNotFoundException("Nenhum preço cadastrado"));
        }
    }

    @Override
    public String toString() {
        return "Descrição:" + description +
                "/n Data do cadastro: " + registeredAt +
                "/n Preço: " + priceHistories;
    }
}
