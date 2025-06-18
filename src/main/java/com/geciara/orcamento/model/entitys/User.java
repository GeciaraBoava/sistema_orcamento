package com.geciara.orcamento.model.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geciara.orcamento.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
<<<<<<< HEAD
=======
import lombok.EqualsAndHashCode;
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Table(name = "users")
<<<<<<< HEAD
public class User implements UserDetails {
=======
@EqualsAndHashCode(callSuper = true)
public class User extends GenericEntitys implements UserDetails {
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

<<<<<<< HEAD
    @Column(unique = true, nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String phone;

    @Column(nullable = false)
    protected String email;

    @Column(nullable = false)
    protected String address;

    @Column(nullable = false)
    protected String city;

    @Column(nullable = false)
    protected String state;

    @Column(nullable = false)
    protected boolean isActive;

=======
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false, updatable = false)
    protected LocalDateTime registeredAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDateTime updatedAt;

<<<<<<< HEAD
=======
    public User(String name,
                String login,
                String phone,
                String email,
                String address,
                String city,
                String state,
                String password,
                UserRole role) {
        super(name, phone, email, address, city, state);
        this.login = login;
        this.password = password;
        this.role = role;
    }

>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
    @Override
    public String toString() {
        return "Nome: " + name +
                "/nLogin: " + login +
                "/nTipo de acesso: " + role +
                "/nTelefone: " +  phone +
                "/nE-mail: " + email +
                "/nEndereço: " + address + ", " + city + "/" + state +
                "/nSituação: " + isActive +
                "/nData de criação:  " + registeredAt +
                "/nData de alteração" + updatedAt;
    }

    //CONFIGURAÇÕES DE SEGURANÇA'


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == UserRole.ADMIN) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_MANAGER"),
                    new SimpleGrantedAuthority("ROLE_BUDGET")
            );
        } else if (role == UserRole.MANAGER) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_MANAGER"),
                    new SimpleGrantedAuthority("ROLE_BUDGET")
            );
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
        }
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        //return UserDetails.super.isAccountNonExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //return UserDetails.super.isAccountNonLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //return UserDetails.super.isCredentialsNonExpired();
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
