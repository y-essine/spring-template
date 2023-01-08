package com.example.exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exam.entities.FamilleAct;
import com.example.exam.entities.Pathologie;
import com.example.exam.entities.Patient;
import com.example.exam.services.IAppService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Exam")
public class AppController {
    @Autowired
    private IAppService appService;

    @PostMapping("/patho/add")
    public Pathologie add(@RequestBody Pathologie p) {
        return appService.ajouterPathologie(p);
    }

    @PostMapping("/patient/add-assign/{codePath}")
    public Patient addAssign(@RequestBody Patient p, @PathVariable String codePath) {
        return appService.ajouterPatientEtAffecterAPathologie(p, codePath);
    }

    @PostMapping("/fa/add")
    public FamilleAct add(@RequestBody FamilleAct f) {
        return appService.ajouterFamilleActeEtActeAssocie(f);
    }

    @PutMapping("/acte/assign/{codeActe}/{codePath}")
    public void assign(@PathVariable String codeActe, @PathVariable String codePath) {
        System.out.println(codeActe + " " + codePath);
        appService.affecterActeAPathologie(codeActe, codePath);
    }

    @GetMapping("/patho/facture/{id}")
    public int facture(@PathVariable String id) {
        return appService.calculerFacture(id);
    }
}
