package com.geciara.orcamento.model.entitys;

import com.geciara.orcamento.model.enums.AcessType;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends GenericEntitys{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_measure_seq")
    @SequenceGenerator(name = "unit_measure_seq", sequenceName = "unit_measure_seq", allocationSize = 1)
    private Long id;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AcessType acessType;

    public User() {}

    public User(String name,
                String phone,
                String contactName,
                String email,
                String adress,
                String city,
                String state,
                String password,
                AcessType acessType) {
        super(name, phone, contactName, email, adress, city, state);
        this.password = password;
        this.acessType = acessType;
    }

    public Long getId() { return id; }


    public AcessType getAcessType() { return acessType; }

    public void setAcessType(AcessType acessType) { this.acessType = acessType; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }


    @Override
    public String toString() {
        return "Nome: " + name +
                "Tipo de acesso: " + acessType + "/n" +
                "Telefone: " +  phone +
                "Contato: " + contactName +
                "E-mail: " + email +
                "Endereço: " + adress + ", " + city + "/" + state + "/n" +
                "Situação: " + active + "/n" +
                "Data de criação:  " + registeredAt + "/n" +
                "Data de alteração" + updatedAt;
    }

}
