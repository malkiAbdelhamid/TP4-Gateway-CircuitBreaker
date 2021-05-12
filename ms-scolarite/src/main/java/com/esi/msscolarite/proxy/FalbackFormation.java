package com.esi.msscolarite.proxy;

import com.esi.msscolarite.DTO.FormationDTO;
import org.springframework.stereotype.Component;

@Component
 public class FalbackFormation implements FormationProxy{
    @Override
    public FormationDTO getFormation(Long idf) {
        return new FormationDTO(idf,"php",0) ;
    }
}

