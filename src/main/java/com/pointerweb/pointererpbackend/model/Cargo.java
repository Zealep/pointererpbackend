package com.pointerweb.pointererpbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @Column(name = "idCargo")
    private String idCargo;

    @Column(name = "idEmpresa")
    private String idEmpresa;

    @Column(name = "GlsCargo")
    private String glsCargo;

    public String getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(String idCargo) {
        this.idCargo = idCargo;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getGlsCargo() {
        return glsCargo;
    }

    public void setGlsCargo(String glsCargo) {
        this.glsCargo = glsCargo;
    }
}
