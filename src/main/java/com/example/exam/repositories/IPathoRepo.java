package com.example.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.exam.entities.Pathologie;

public interface IPathoRepo extends JpaRepository<Pathologie, Long> {
    @Query("select p from Pathologie p where p.code = ?1")
    public Pathologie findByCode(String code);

    @Query("select p from Pathologie p where p.code = ?1")
    public Pathologie findByCodeNonArchived(String code);

    @Query("select p from Pathologie p where (p.libelle = ?1 or p.code = ?1) and p.archive = false")
    public Pathologie findByLibelleOrCodeNonArchived(String identifiant);
}
