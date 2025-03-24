package com.geciara.orcamento.model.entitys;

import com.geciara.orcamento.model.enums.CustomerType;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends GenericEntitys {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private CustomerType customerType;

    public Customer() { }

    public Customer(String name,
                    String phone,
                    String contactName,
                    String email,
                    String adress,
                    String city,
                    String state,
                    CustomerType customerType) {
        super(name, phone, contactName, email, adress, city, state);
        this.customerType = customerType;

    }

    public CustomerType getCustomerType() { return customerType; }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Long getId() { return id; }
}
