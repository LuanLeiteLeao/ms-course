package com.devsuperior.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping(value = "/search")
    ResponseEntity<User> findByEmail(@RequestParam String email){
        User user = service.findByEmail(email);
        return ResponseEntity.ok(user);
    }
    
}
