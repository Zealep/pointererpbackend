package com.pointerweb.pointererpbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "centroscosto")
public class CentrosCosto {

    @Id
    @Column(name = "idCentroCosto")
    private String idCentroCosto;

    @Column(name = "idEmpresa")
    private String idEmpresa;

    @Column(name = "GlsCentroCosto")
    private String glsCentroCosto;

    @Column(name = "estCentroCosto")
    private String estCentroCosto;

    public String getIdCentroCosto() {
        return idCentroCosto;
    }

    public void setIdCentroCosto(String idCentroCosto) {
        this.idCentroCosto = idCentroCosto;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getGlsCentroCosto() {
        return glsCentroCosto;
    }

    public void setGlsCentroCosto(String glsCentroCosto) {
        this.glsCentroCosto = glsCentroCosto;
    }

    public String getEstCentroCosto() {
        return estCentroCosto;
    }

    public void setEstCentroCosto(String estCentroCosto) {
        this.estCentroCosto = estCentroCosto;
    }
}
