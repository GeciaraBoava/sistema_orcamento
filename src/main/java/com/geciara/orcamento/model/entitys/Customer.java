package com.geciara.orcamento.model.entitys;

import com.geciara.orcamento.model.enums.CustomerType;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer extends GenericEntitys {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    protected String contactName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerType customerType;

    public Customer(String name,
                    String phone,
                    String contactName,
                    String email,
                    String adress,
                    String city,
                    String state,
                    CustomerType customerType) {
        super(name, phone, email, adress, city, state);
        this.customerType = customerType;
        this.contactName = contactName;
    }

    @Override
    public String toString() {
        return "Nome: " + name +
                "/n Telefone: " +  phone +
                "/n Contato: " + contactName +
                "/n E-mail: " + email + "/n" +
                "/n Endereço: " + adress + ", " + city + "/" + state +
                "/n Situação: " + isActive +
                "/n Tipo: " + customerType +
                "/n Data de criação:  " + registeredAt + "/n" +
                "/n Data de alteração" + updatedAt;
    }

}
