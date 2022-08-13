package com.pointerweb.pointererpbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "areas")
public class Areas {

    @Id
    @Column(name = "IdArea")
    private String idArea;

    @Column(name = "IdEmpresa")
    private String idEmpresa;

    @Column(name = "GlsArea")
    private String glsArea;

    @Column(name = "EstArea")
    private String estArea;

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getGlsArea() {
        return glsArea;
    }

    public void setGlsArea(String glsArea) {
        this.glsArea = glsArea;
    }

    public String getEstArea() {
        return estArea;
    }

    public void setEstArea(String estArea) {
        this.estArea = estArea;
    }
}
