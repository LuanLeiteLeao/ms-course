package com.devsuperior.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclients.UserFeignClients;

@Service
public class UserService {
    @Autowired
    private UserFeignClients userFeignClients;

    public User findByEmail(String email){
        User user = userFeignClients.findByEmail(email).getBody();
        return user;
    }
}
