package com.geciara.orcamento.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geciara.orcamento.model.types.CustomerType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private CustomerType customerType;
    private String name;
    private String phone;
    private String contactName;
    private String email;
    private String adress;
    private String city;
    private String state;
    private boolean active;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime creationDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime updateDate;

    public Customer() {}

    public Customer(long id,
                    CustomerType customerType,
                    String name,
                    String phone,
                    String contactName,
                    String email,
                    String adress,
                    String city,
                    String state) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.phone = phone;
        this.contactName = contactName;
        this.email = email;
        this.adress = adress;
        this.city = city;
        this.state = state;
        this.active = true;
        this.creationDate = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public CustomerType getCustomerType() { return customerType; }

    public void setCustomerType(CustomerType customerType) { this.customerType = customerType; }

    public String getName() {
        return  name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() { return adress; }

    public void setAdress(String adress) { this.adress = adress; }

    public String getCity() { return city; }

    public void setCity(String city) { this.adress = city; }

    public String getState() { return city; }

    public void setState(String state) { this.adress = state; }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "Nome: " + name +
                "Telefone: " +  phone +
                "Contato: " + contactName +
                "E-mail: " + email +
                "Endereço: " + adress + ", " + city + "/" + state + "/n" +
                "Situação: " + active + "/n" +
                "Data de criação:  " + creationDate;
    }

}
