package com.geciara.orcamento.model.services;

import com.geciara.orcamento.model.entitys.Material;
import com.geciara.orcamento.repository.CustomerRepository;
import com.geciara.orcamento.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<Material, Long>{

    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

}
