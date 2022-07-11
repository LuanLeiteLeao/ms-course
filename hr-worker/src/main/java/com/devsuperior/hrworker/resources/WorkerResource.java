package com.devsuperior.hrworker.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.devsuperior.hrworker.repositories.WorkerRepository;

import java.net.HttpRetryException;
import java.util.List;
import java.util.Optional;

import com.devsuperior.hrworker.entities.Worker;;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker worker = repository.findById(id)
                    .map(mapper->mapper)
                    .orElseThrow(()-> 
                                    new ResponseStatusException(
                                        HttpStatus.BAD_REQUEST,"Trabalhador não existe")  
                                );

        return ResponseEntity.ok(worker);
    }
}
