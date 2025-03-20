package com.geciara.orcamento.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private MaterialType type;
    private String description;
    private UnitMeasure unitMeasure;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime creationDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime updateDate;

    private Double price;
    private boolean active;

    public Material() {}

    public Material(MaterialType type,
                    String description,
                    UnitMeasure unitMeasure,
                    Double price) {
        this.type = type;
        this.description = description;
        this.unitMeasure = unitMeasure;
        this.creationDate = LocalDateTime.now();
        this.price = price;
        this.active = true;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public MaterialType getType() { return type; }

    public void setType(MaterialType type) { this.type = type; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public UnitMeasure getUnitMeasure() { return unitMeasure; }

    public void setUnitMeasure(UnitMeasure unitMeasure) { this.unitMeasure = unitMeasure;}

    public LocalDateTime getCreationDate() { return creationDate; }

    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

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
