package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ListContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String link;
    private String otsikko;
    private String kuvaus;
    private String avainsana;

    // Constructors

    public ListContent() {
    }

    public ListContent(String link, String otsikko, String kuvaus, String avainsana) {
        this.link = link;
        this.otsikko = otsikko;
        this.kuvaus = kuvaus;
        this.avainsana = avainsana;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getOtsikko() {
        return otsikko;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public String getAvainsana() {
        return avainsana;
    }

    public void setAvainsana(String avainsana) {
        this.avainsana = avainsana;
    }
}
