package com.devsuperior.hrworker.resources;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger Logger = LoggerFactory.getLogger(WorkerResource.class);
/*
    @Value("${hr-worker.properties}")
    private String testConfig;
 */
    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;
    /*
    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfig(){
        Logger.info("-------->CONFIG : "+testConfig);

        return ResponseEntity.noContent().build();
    }
    */
    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){

        Logger.info("PORT = "+env.getProperty("local.server.port"));

        Worker worker = repository.findById(id)
                    .map(mapper->mapper)
                    .orElseThrow(()-> 
                                    new ResponseStatusException(
                                        HttpStatus.BAD_REQUEST,"Trabalhador não existe")  
                                );

        return ResponseEntity.ok(worker);
    }
}
