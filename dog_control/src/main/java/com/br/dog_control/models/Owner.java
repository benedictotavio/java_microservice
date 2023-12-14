package com.br.dog_control.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = Owner.TABLE_NAME)
public class Owner {

    final static String TABLE_NAME = "Owner";

    @Id
    @Column(name = "document", unique = true, updatable = false)
    @NotBlank(message = "document is mandatory")
    private String document;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "name is mandatory")
    private String name;

    @Column(name = "email", nullable = false)
    @NotNull(message = "Email must be defined")
    @Email
    private String email;

    @Column(name = "premium", nullable = false, columnDefinition = "boolean default false")
    private boolean premium;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    @Override
    public String toString() {
        return "Owner [document=" + document + ", name=" + name + "]";
    }
}
