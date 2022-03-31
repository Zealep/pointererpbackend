package com.pointerweb.pointererpbackend.model.dto;

public class UsuarioModulo {

    private String idModulo;
    private String GlsModulo;

    public UsuarioModulo(String idModulo, String glsModulo) {
        this.idModulo = idModulo;
        GlsModulo = glsModulo;
    }

    public UsuarioModulo(){}

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getGlsModulo() {
        return GlsModulo;
    }

    public void setGlsModulo(String glsModulo) {
        GlsModulo = glsModulo;
    }
}
