package com.geciara.orcamento.model.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.geciara.orcamento.model.enums.CustomerType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    private Long id;

    @Embedded
    private Register register;

    @Column(nullable = false)
    private String contactName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerType customerType;

    @Column(nullable = false)
    private boolean isActive;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(nullable = false, updatable = false)
    private LocalDateTime registeredAt;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Nome: " + register.getName() +
                "\n Telefone: " +  register.getPhone() +
                "\n Contato: " + contactName +
                "\n E-mail: " + register.getEmail() + "\n" +
                "\n Endereço: " + register.getAddress() + ", " + register.getCity() + "/" + register.getUf() +
                "\n Situação: " + isActive +
                "\n Tipo: " + customerType +
                "\n Data de criação:  " + registeredAt + "\n" +
                "\n Data de alteração" + updatedAt;
    }
}
