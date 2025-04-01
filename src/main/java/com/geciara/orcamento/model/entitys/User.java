package com.geciara.orcamento.model.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geciara.orcamento.model.enums.AcessType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends GenericEntitys{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_measure_seq")
    @SequenceGenerator(name = "unit_measure_seq", sequenceName = "unit_measure_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AcessType acessType;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false, updatable = false)
    protected LocalDateTime registeredAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDateTime updatedAt;

    public User(String name,
                String phone,
                String email,
                String adress,
                String city,
                String state,
                String password,
                AcessType acessType) {
        super(name, phone, email, adress, city, state);
        this.password = password;
        this.acessType = acessType;
    }

    @Override
    public String toString() {
        return "Nome: " + name +
                "Tipo de acesso: " + acessType + "/n" +
                "Telefone: " +  phone +
                "E-mail: " + email +
                "Endereço: " + adress + ", " + city + "/" + state + "/n" +
                "Situação: " + isActive + "/n" +
                "Data de criação:  " + registeredAt + "/n" +
                "Data de alteração" + updatedAt;
    }
}
