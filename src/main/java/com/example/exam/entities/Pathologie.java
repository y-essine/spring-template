package com.example.exam.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pathologies")
@Getter
@Setter
public class Pathologie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String libelle;
    private String description;
    private Boolean archive = false;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Acte> actes = new HashSet<Acte>();
}
