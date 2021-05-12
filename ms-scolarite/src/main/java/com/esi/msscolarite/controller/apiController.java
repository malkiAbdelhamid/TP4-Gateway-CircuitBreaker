package com.esi.msscolarite.controller;

import com.esi.msscolarite.DTO.FormationDTO;
import com.esi.msscolarite.dao.EtudiantRepository;
import com.esi.msscolarite.entities.Etudiant;
import com.esi.msscolarite.proxy.FormationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class apiController {

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    FormationProxy formationProxy;

    @GetMapping("/etudiant/{id}")
    public Etudiant getEtudiantWithFormation(@PathVariable("id") Long ide)
    {
        Etudiant etudiant=etudiantRepository.findById(ide).get();

        FormationDTO formation= formationProxy.getFormation(etudiant.getIdFormation());

        etudiant.setFormation(formation);

        return  etudiant;
    }


    @GetMapping("/etudiant")
    public List<Etudiant> getEtudiantsWithFormation()
    {
        List<Etudiant> etudiants= etudiantRepository.findAll();

        etudiants.forEach((e)->{
                    e.setFormation(formationProxy.getFormation(e.getIdFormation()));
                }
        );
        return etudiants;
    }
}
