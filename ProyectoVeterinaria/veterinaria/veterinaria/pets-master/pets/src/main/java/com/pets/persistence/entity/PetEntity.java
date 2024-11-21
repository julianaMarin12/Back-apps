package com.pets.persistence.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pets")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String species;
    private String gender;
    private Integer age;
    private Double weight;

    @Column(name = "medical_history_link")
    private String medicalHistoryLink;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private ClientEntity owner;


    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicalHistoryLink() {
        return medicalHistoryLink;
    }
    public void setMedicalHistoryLink(String medicalHistoryLink) {
        this.medicalHistoryLink = medicalHistoryLink;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ClientEntity getOwner() {
        return owner;
    }
    public void setOwner(ClientEntity owner) {
        this.owner = owner;
    }


    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }

    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
}