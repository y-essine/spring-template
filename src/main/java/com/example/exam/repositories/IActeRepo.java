package com.example.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.exam.entities.Acte;

public interface IActeRepo extends JpaRepository<Acte, Long> {
    @Query("select a from Acte a where a.code = ?1")
    public Acte findByCode(String code);
}
