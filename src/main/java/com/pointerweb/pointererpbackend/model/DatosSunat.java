package com.pointerweb.pointererpbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "datossunat")
public class DatosSunat {

    @Id
    @Column(name = "IdDato")
    private String idDato;

    @Column(name = "iddatoSunat")
    private String idDatoSunat;

    @Column(name = "GlsDatoSunat")
    private String glsDatoSunat;

    @Column(name = "GlsDatoSunatLarga")
    private String  glsDatoSunatLarga;

    @Column(name = "codGrupoSunat")
    private String  codGrupoSunat;

    @Column(name = "estdatoSunat")
    private String  estdatoSunat;


    public String getCodGrupoSunat() {
        return codGrupoSunat;
    }

    public void setCodGrupoSunat(String codGrupoSunat) {
        this.codGrupoSunat = codGrupoSunat;
    }

    public String getIdDato() {
        return idDato;
    }

    public void setIdDato(String idDato) {
        this.idDato = idDato;
    }

    public String getIdDatoSunat() {
        return idDatoSunat;
    }

    public void setIdDatoSunat(String idDatoSunat) {
        this.idDatoSunat = idDatoSunat;
    }

    public String getGlsDatoSunat() {
        return glsDatoSunat;
    }

    public void setGlsDatoSunat(String glsDatoSunat) {
        this.glsDatoSunat = glsDatoSunat;
    }

    public String getGlsDatoSunatLarga() {
        return glsDatoSunatLarga;
    }

    public void setGlsDatoSunatLarga(String glsDatoSunatLarga) {
        this.glsDatoSunatLarga = glsDatoSunatLarga;
    }

    public String getEstdatoSunat() {
        return estdatoSunat;
    }

    public void setEstdatoSunat(String estdatoSunat) {
        this.estdatoSunat = estdatoSunat;
    }
}
