package com.example.exam.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.exam.enums.TypePiece;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypePiece typePiece;
    private String idPiece;
    @Temporal(TemporalType.DATE)
    private Date dateEmission;
    private String nom;
    private String prenom;
    @ManyToMany
    private Set<Pathologie> pathologies = new HashSet<Pathologie>();
}
