package com.geciara.orcamento.repository;

import com.geciara.orcamento.model.entitys.UserEntity;
import com.geciara.orcamento.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserDetails findByLogin(String login);
    List<UserEntity> findByRole(UserRole role);
}