package com.geciara.orcamento.services;

import com.geciara.orcamento.model.entitys.User;
import com.geciara.orcamento.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericServiceImpl<User, UserRepository> {

    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

}
