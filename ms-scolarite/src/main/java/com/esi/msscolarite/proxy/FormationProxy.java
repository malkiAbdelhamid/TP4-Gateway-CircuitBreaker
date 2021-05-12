package com.esi.msscolarite.proxy;

import com.esi.msscolarite.DTO.FormationDTO;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ms-formation")
@LoadBalancerClient(name="ms-formation",configuration = LBConfiguration.class)
public interface FormationProxy {
    @GetMapping("/formations/{id}")
    @Bulkhead(name="fall1", fallbackMethod = "fallbackFormation")
    FormationDTO getFormation(@PathVariable("id") Long idf);

    default FormationDTO fallbackFormation(Long idf,Throwable throwable) {
        return new FormationDTO(idf,"php",0) ;
    }
}
