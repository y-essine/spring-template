package com.example.exam.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "familles_actes")
@Getter
@Setter
public class FamilleAct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String libelle;
    private String description;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "familleAct")
    private Set<Acte> actes = new HashSet<Acte>();
}
