package com.geciara.orcamento.model.entitys;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonFormat;
=======
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
import com.geciara.orcamento.model.enums.CustomerType;
import jakarta.persistence.*;
import lombok.*;

<<<<<<< HEAD
import java.time.LocalDateTime;

=======
@EqualsAndHashCode(callSuper = true)
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
<<<<<<< HEAD
public class Customer {
=======
public class Customer extends GenericEntitys {
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    private Long id;

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

=======
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
    @Column(nullable = false)
    protected String contactName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerType customerType;

<<<<<<< HEAD
    @Column(nullable = false)
    protected boolean isActive;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false, updatable = false)
    protected LocalDateTime registeredAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDateTime updatedAt;
=======
    public Customer(String name,
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
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4

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
