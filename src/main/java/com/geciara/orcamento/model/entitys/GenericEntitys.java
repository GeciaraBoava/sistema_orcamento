package com.geciara.orcamento.model.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class GenericEntitys {

    protected String name;
    protected String phone;
    protected String contactName;
    protected String email;
    protected String adress;
    protected String city;
    protected String state;
    protected boolean active;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDateTime creationDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDateTime updateDate;

    public GenericEntitys() {}

    public GenericEntitys(String name,
                          String phone,
                          String contactName,
                          String email,
                          String adress,
                          String city,
                          String state) {
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

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isNotActive() {
        return active = false;
    }

    public boolean isActive() {
        return active = true;
    }

    @Override
    public String toString() {
        return "Nome: " + name + "/n" +
                "Telefone: " +  phone + "/n" +
                "Contato: " + contactName + "/n" +
                "E-mail: " + email + "/n" +
                "Endereço: " + adress + ", " + city + "/" + state + "/n" +
                "Situação: " + active + "/n" +
                "Data de criação:  " + creationDate + "/n" +
                "Data de alteração" + updateDate;
    }

}
