package com.geciara.orcamento.model.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_seq")
    @SequenceGenerator(name = "material_seq", sequenceName = "material_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 255, unique = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "material_type_id", nullable = false)
    private MaterialType type;

    @ManyToOne
    @JoinColumn(name = "unit_measure_id", nullable = false)
    private UnitMeasure unitMeasure;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime registeredAt;

    @Column(name = "current_price")
    private BigDecimal currentPrice;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //remove preços se o material for deletado e vice-versa
    @JoinColumn(name = "material_id")
    private Set<PriceHistory> priceHistories = new HashSet<>();

    @Column(nullable = false)
    private boolean active;

    public Material() {}

    public Material(String description,
                    MaterialType type,
                    UnitMeasure unitMeasure,
                    BigDecimal currentPrice) {
        this.description = description;
        this.type = type;
        this.unitMeasure = unitMeasure;
        this.registeredAt = LocalDateTime.now();
        this.currentPrice = currentPrice;
        this.active = true;
    }

    public Long getId() { return id; }

    public MaterialType getType() { return type; }

    public void setType(MaterialType type) { this.type = type; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public UnitMeasure getUnitMeasure() { return unitMeasure; }

    public void setUnitMeasure(UnitMeasure unitMeasure) { this.unitMeasure = unitMeasure;}

    public LocalDateTime getRegisteredAt() { return registeredAt; }

    public void setRegisteredAt(LocalDateTime registeredAt) { this.registeredAt = registeredAt; }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    //manter o preço principal da planilha de insumos sempre atualizado
    public void updatePrice(BigDecimal newPrice, User user) {
        PriceHistory updatedPrice = new PriceHistory(newPrice, user.getName(), LocalDateTime.now());

        priceHistories.add(updatedPrice);
        this.currentPrice = newPrice;
    }


    //buscar preço conforme data-base do orçamento
    public BigDecimal getPriceByBaseData(LocalDate baseDate) throws IllegalAccessException {
        LocalDateTime baseDateTime = baseDate.atTime(LocalTime.MAX);

        //busca o preço criado até a data base
        Optional<PriceHistory> priceUpToBaseDate = priceHistories.stream()
                .filter(ph -> !ph.getRegisteredAt().isAfter(baseDateTime))
                .max(Comparator.comparing(PriceHistory::getRegisteredAt));

        if(priceUpToBaseDate.isPresent()) {
            return priceUpToBaseDate.get().getPrice();
        } else {
            return  priceHistories.stream()
                    .min(Comparator.comparingLong(
                            ph -> ChronoUnit.DAYS.between(baseDateTime.toLocalDate(),
                                    ph.getRegisteredAt().toLocalDate())))
                    .map(PriceHistory::getPrice)
                    .orElseThrow(() -> new IllegalAccessException("Nenhum preço cadastrado"));
        }
    }

    @Override
    public String toString() {
        return "Descrição:" + description + "/n" +
                "Data do cadastro: " + registeredAt + "/n" +
                "Preço: " + priceHistories;
    }
}
