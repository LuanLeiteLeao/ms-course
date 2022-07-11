package com.devsuperior.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "hr-worker",url = "locahost:8001",path = "/workers")
public interface WorkerFeignClients {

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id);
    
}
