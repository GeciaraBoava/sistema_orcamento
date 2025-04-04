package com.geciara.orcamento.model.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class GenericEntitys {

    @Column(unique = true, nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String phone;

    @Column(nullable = false)
    protected String email;

    @Column(nullable = false)
    protected String address;

    @Column(nullable = false)
    protected String city;

    @Column(nullable = false)
    protected String state;

    @Column(nullable = false)
    protected boolean isActive;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false, updatable = false)
    protected LocalDateTime registeredAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDateTime updatedAt;

    public GenericEntitys(String name,
                          String phone,
                          String email,
                          String address,
                          String city,
                          String state) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Nome: " + name +
                "/n Telefone: " +  phone +
                "/n E-mail: " + email +
                "/n Endereço: " + address + ", " + city + "/" + state +
                "/n Situação: " + isActive +
                "/n Data de criação:  " + registeredAt +
                "/n Data de alteração" + updatedAt;
    }

}
