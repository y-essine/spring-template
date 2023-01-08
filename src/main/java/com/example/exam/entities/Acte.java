package com.example.exam.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "actes")
@Getter
@Setter
public class Acte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private int cotation;
    private float prixUnit;
    private String designation;
    @ManyToOne
    @JsonIgnore
    private FamilleAct familleAct;
    @ManyToMany(mappedBy = "actes")
    @JsonIgnore
    private Set<Pathologie> pathologies = new HashSet<Pathologie>();
}
