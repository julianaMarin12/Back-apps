package com.pets.domain.dto;

import jakarta.validation.constraints.*;

public class ClientDTO {
    private Integer id;

    @NotBlank @Size(max = 100) @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "invalid format")
    private String name;

    @NotBlank @Email @Size(max = 100)
    private String email;

    @Pattern(regexp = "^\\d{0,10}$", message = "invalid format")
    private String phoneNumber;

    @NotBlank @Size(max = 255)
    private String address;

    public ClientDTO(Integer id, String name, String email, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}