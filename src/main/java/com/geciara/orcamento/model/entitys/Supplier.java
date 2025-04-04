package com.geciara.orcamento.model.entitys;

import com.geciara.orcamento.model.enums.CustomerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "supplier")
public class Supplier extends GenericEntitys {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    @SequenceGenerator(name = "supplier_seq", sequenceName = "supplier_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    protected String contactName;

    public Supplier(String name,
                    String phone,
                    String contactName,
                    String email,
                    String address,
                    String city,
                    String state) {
        super(name, phone, email, address, city, state);
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
                "/n Data de criação:  " + registeredAt + "/n" +
                "/n Data de alteração" + updatedAt;
    }

}
