package com.geciara.orcamento.model.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_seq")
    @SequenceGenerator(name = "material_seq", sequenceName = "material_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private MaterialType type;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false)
    private UnitMeasure unitMeasure;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime creationDate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private boolean active;

    public Material() {}

    public Material(MaterialType type,
                    String description,
                    UnitMeasure unitMeasure,
                    BigDecimal price) {
        this.type = type;
        this.description = description;
        this.unitMeasure = unitMeasure;
        this.creationDate = LocalDateTime.now();
        this.price = price;
        this.active = true;
    }

    public Long getId() { return id; }

    public MaterialType getType() { return type; }

    public void setType(MaterialType type) { this.type = type; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public UnitMeasure getUnitMeasure() { return unitMeasure; }

    public void setUnitMeasure(UnitMeasure unitMeasure) { this.unitMeasure = unitMeasure;}

    public LocalDateTime getCreationDate() { return creationDate; }

    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Descrição:" + description + "/n" +
                "Data do cadastro: " + creationDate + "/n" +
                "Preço: " + price;
    }
}
