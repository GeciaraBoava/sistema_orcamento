package com.geciara.orcamento.model.entitys;

import com.geciara.orcamento.model.enums.CustomerType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity extends GenericEntitys {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    protected String contactName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerType customerType;

    public CustomerEntity(String name,
                          String phone,
                          String contactName,
                          String email,
                          String address,
                          String city,
                          String state,
                          CustomerType customerType) {
        super(name, phone, email, address, city, state);
        this.customerType = customerType;
        this.contactName = contactName;
    }

    @Override
    public String toString() {
        return "Nome: " + name +
                "/n Telefone: " +  phone +
                "/n Contato: " + contactName +
                "/n E-mail: " + email + "/n" +
                "/n Endereço: " + address + ", " + city + "/" + state +
                "/n Situação: " + isActive +
                "/n Tipo: " + customerType +
                "/n Data de criação:  " + registeredAt + "/n" +
                "/n Data de alteração" + updatedAt;
    }

}
