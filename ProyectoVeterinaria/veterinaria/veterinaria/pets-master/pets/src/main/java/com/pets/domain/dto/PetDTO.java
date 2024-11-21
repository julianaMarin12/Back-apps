package com.pets.domain.dto;

import jakarta.validation.constraints.*;

public class PetDTO {
    private Integer id;

    @NotBlank @Size(max = 100) @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "invalid format")
    private String name;

    @NotNull @Positive
    private Integer ownerId;

    @NotBlank @Size(max = 50) @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "invalid format")
    private String species;

    @NotBlank @Pattern(regexp = "^(Male|Female)$", message = "Male or Female only")
    private String gender;

    @NotNull @Positive
    private Integer age;

    @NotNull @Positive
    private Double weight;

    @Size(max = 150)
    private String medicalHistoryLink;

    public PetDTO(Integer id, String name, Integer ownerId, String species, String gender, Integer age, Double weight, String medicalHistoryLink) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.species = species;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.medicalHistoryLink = medicalHistoryLink;
    }

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

    public Integer getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
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