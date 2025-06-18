package com.geciara.orcamento.repository;

import com.geciara.orcamento.model.entitys.User;
import com.geciara.orcamento.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);
    List<User> findByRole(UserRole role);
<<<<<<< HEAD
    boolean existsByEmail(String email);
=======
>>>>>>> 7fafd5efd6d2e5915f0fa6fd103be68ee248bae4
}