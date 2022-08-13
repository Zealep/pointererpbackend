package com.pointerweb.pointererpbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "datos")
public class Datos {

    @Id
    @Column(name = "idDato")
    private String idDato;

    @Column(name = "idTipoDatos")
    private String idTipoDatos;

    @Column(name = "GlsDato")
    private String glsDato;

    @Column(name = "estDato")
    private String estDato;

    @Column(name = "valorDato")
    private String valorDato;

    @Column(name = "IdDatoSunat")
    private String IdDatoSunat;

    public String getIdDato() {
        return idDato;
    }

    public void setIdDato(String idDato) {
        this.idDato = idDato;
    }

    public String getIdTipoDatos() {
        return idTipoDatos;
    }

    public void setIdTipoDatos(String idTipoDatos) {
        this.idTipoDatos = idTipoDatos;
    }

    public String getGlsDato() {
        return glsDato;
    }

    public void setGlsDato(String glsDato) {
        this.glsDato = glsDato;
    }

    public String getEstDato() {
        return estDato;
    }

    public void setEstDato(String estDato) {
        this.estDato = estDato;
    }

    public String getValorDato() {
        return valorDato;
    }

    public void setValorDato(String valorDato) {
        this.valorDato = valorDato;
    }

    public String getIdDatoSunat() {
        return IdDatoSunat;
    }

    public void setIdDatoSunat(String idDatoSunat) {
        IdDatoSunat = idDatoSunat;
    }
}
