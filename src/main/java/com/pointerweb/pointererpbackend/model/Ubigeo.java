package com.pointerweb.pointererpbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ubigeo")
public class Ubigeo {

    @Id
    @Column(name = "idDistrito")
    private String idDistrito;
    @Column(name = "idDpto")
    private String idDpto;
    @Column(name = "idProv")
    private String idProv;
    @Column(name = "idDist")
    private String idDist;
    @Column(name = "GlsUbigeo")
    private String glsUbigeo;
    @Column(name = "estUbigeo")
    private String estUbigeo;

    public String getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(String idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(String idDpto) {
        this.idDpto = idDpto;
    }

    public String getIdProv() {
        return idProv;
    }

    public void setIdProv(String idProv) {
        this.idProv = idProv;
    }

    public String getIdDist() {
        return idDist;
    }

    public void setIdDist(String idDist) {
        this.idDist = idDist;
    }

    public String getGlsUbigeo() {
        return glsUbigeo;
    }

    public void setGlsUbigeo(String glsUbigeo) {
        this.glsUbigeo = glsUbigeo;
    }

    public String getEstUbigeo() {
        return estUbigeo;
    }

    public void setEstUbigeo(String estUbigeo) {
        this.estUbigeo = estUbigeo;
    }
}
