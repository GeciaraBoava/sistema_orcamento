package com.geciara.orcamento.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateRegister;
    private Double price;

    public Material() {}

    public Material(String type, String description, LocalDate dateRegister, Double price) {
        this.type = type;
        this.description = description;
        this.dateRegister = dateRegister;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Descrição:" + description + "/n" +
                "Data do cadastro: " + dateRegister + "/n" +
                "Preço: " + price;
    }
}
