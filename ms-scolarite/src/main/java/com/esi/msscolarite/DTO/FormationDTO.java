package com.esi.msscolarite.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormationDTO {
    private Long idFormation;
    private String nom;
    private int duree;
}
