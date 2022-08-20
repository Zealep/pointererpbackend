package com.pointerweb.pointererpbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documentos")
public class Documento {
    @Id
    @Column(name = "idDocumento")
    private String idDocumento;

    @Column(name = "GlsDocumento")
    private String glsDocumento;

    @Column(name = "AbreDocumento")
    private String abreDocumento;

    @Column(name = "estDocumentos")
    private String estDocumentos;

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getGlsDocumento() {
        return glsDocumento;
    }

    public void setGlsDocumento(String glsDocumento) {
        this.glsDocumento = glsDocumento;
    }

    public String getAbreDocumento() {
        return abreDocumento;
    }

    public void setAbreDocumento(String abreDocumento) {
        this.abreDocumento = abreDocumento;
    }

    public String getEstDocumentos() {
        return estDocumentos;
    }

    public void setEstDocumentos(String estDocumentos) {
        this.estDocumentos = estDocumentos;
    }
}
