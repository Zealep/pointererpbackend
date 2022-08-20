package com.pointerweb.pointererpbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monedas")
public class Moneda {

    @Id
    @Column
    private String idMoneda;

    @Column
    private String glsMoneda;

    @Column
    private String estMoneda;

    @Column
    private String simbolo;

    public String getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(String idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getGlsMoneda() {
        return glsMoneda;
    }

    public void setGlsMoneda(String glsMoneda) {
        this.glsMoneda = glsMoneda;
    }

    public String getEstMoneda() {
        return estMoneda;
    }

    public void setEstMoneda(String estMoneda) {
        this.estMoneda = estMoneda;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
