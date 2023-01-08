package com.example.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exam.entities.Patient;

public interface IPatientRepo extends JpaRepository<Patient, Long> {

}
