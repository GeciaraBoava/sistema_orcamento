package com.geciara.orcamento.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geciara.orcamento.entitys.enums.AcessType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private AcessType acessType;
    private String password;
    private boolean active;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime creationDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime updateDate;

    public User() {}

    public User(long id,
                String name,
                String email,
                AcessType acessType,
                String password) {
        this.name = name;
        this.email = email;
        this.acessType = acessType;
        this.password = password;
        this.active = true;
        this.creationDate = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return  name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public AcessType getAcessType() { return acessType; }

    public void setAcessType(AcessType acessType) { this.acessType = acessType; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public boolean getActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

    public LocalDateTime getCreationDate() { return creationDate; }

    public LocalDateTime getUpdateDate() { return updateDate; }

    public void setUpdateDate(LocalDateTime updateDate) { this.updateDate = updateDate; }

    @Override
    public String toString() {
        return "Nome: " + name + "/n" +
                "E-mail: " +  email + "/n" +
                "Tipo de acesso: " + acessType + "/n" +
                "Situação: " + active + "/n" +
                "Data de criação:  " + creationDate + "/n" +
                "Data de alteração" + updateDate;
    }

}
