package com.example.exam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.exam.entities.Acte;
import com.example.exam.entities.FamilleAct;
import com.example.exam.entities.Pathologie;
import com.example.exam.entities.Patient;
import com.example.exam.repositories.IActeRepo;
import com.example.exam.repositories.IFARepo;
import com.example.exam.repositories.IPathoRepo;
import com.example.exam.repositories.IPatientRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppService implements IAppService {
    @Autowired
    private IPathoRepo pathoRepo;
    @Autowired
    private IPatientRepo patientRepo;
    @Autowired
    private IFARepo faRepo;
    @Autowired
    private IActeRepo acteRepo;

    public Pathologie ajouterPathologie(Pathologie p) {
        return pathoRepo.save(p);
    }

    public Patient ajouterPatientEtAffecterAPathologie(Patient p, String codePath) {
        Pathologie patho = pathoRepo.findByCode(codePath);
        p.getPathologies().add(patho);
        return patientRepo.save(p);
    }

    public FamilleAct ajouterFamilleActeEtActeAssocie(FamilleAct f) {
        FamilleAct fr = faRepo.save(f);
        for (Acte a : f.getActes()) {
            a.setFamilleAct(f);
            acteRepo.save(a);
        }
        return fr;
    }

    public void affecterActeAPathologie(String codeActe, String codePath) {
        Pathologie patho = pathoRepo.findByCodeNonArchived(codePath);
        System.out.println("passed");
        Acte acte = acteRepo.findByCode(codeActe);
        patho.getActes().add(acte);
        pathoRepo.save(patho);
    }

    public int calculerFacture(String id) {
        Pathologie patho = pathoRepo.findByLibelleOrCodeNonArchived(id);
        int facture = 0;
        if (patho != null) {
            for (Acte a : patho.getActes()) {
                facture += a.getCotation() * a.getPrixUnit();
            }
        }
        return facture;
    }

    @Scheduled(cron = "*/5 * * * * *")
    @Override
    public void calculerNombreActesParPathologie() {
        for (Pathologie p : pathoRepo.findAll()) {
            log.info(p.getActes().size() + " actes pour la pathologie " + p.getLibelle());
        }
        log.info("=================================");
    }
}
