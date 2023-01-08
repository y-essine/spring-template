package com.example.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.exam.entities.FamilleAct;

public interface IFARepo extends JpaRepository<FamilleAct, Long> {
    @Query("select f from FamilleAct f where f.code = ?1")
    public FamilleAct findByCode(String code);

}
