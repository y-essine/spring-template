package com.example.exam.services;

import com.example.exam.entities.FamilleAct;
import com.example.exam.entities.Pathologie;
import com.example.exam.entities.Patient;

public interface IAppService {
    public Pathologie ajouterPathologie(Pathologie p);

    public Patient ajouterPatientEtAffecterAPathologie(Patient p, String codePath);

    public FamilleAct ajouterFamilleActeEtActeAssocie(FamilleAct fa);

    public void affecterActeAPathologie(String codeActe, String codePath);

    public int calculerFacture(String id);

    public void calculerNombreActesParPathologie();
}
