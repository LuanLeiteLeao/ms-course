package com.devsuperior.hruser.resources;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UserRespository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRespository userRespository;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){


        User user = userRespository.findById(id)
                    .map(userFinded->userFinded)
                    .orElseThrow(()-> 
                                    new ResponseStatusException(
                                        BAD_REQUEST,"Usuário não existe")  
                                );

        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findById(@RequestParam String email){


        User user = userRespository.findByEmail(email)
                    .map(userFinded->userFinded)
                    .orElseThrow(()-> 
                                    new ResponseStatusException(
                                        BAD_REQUEST,"Usuário não existe")  
                                );

        return ResponseEntity.ok(user);
    }
    
}
