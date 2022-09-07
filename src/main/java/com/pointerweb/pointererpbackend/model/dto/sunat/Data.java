package com.pointerweb.pointererpbackend.model.dto.sunat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

public class Data {
    private Integer estadoCp;
    private String estadoRuc;
    private String condDomiRuc;
    private List<String> observaciones;

    public Integer getEstadoCp() {
        return estadoCp;
    }

    public void setEstadoCp(Integer estadoCp) {
        this.estadoCp = estadoCp;
    }

    public String getEstadoRuc() {
        return estadoRuc;
    }

    public void setEstadoRuc(String estadoRuc) {
        this.estadoRuc = estadoRuc;
    }

    public String getCondDomiRuc() {
        return condDomiRuc;
    }

    public void setCondDomiRuc(String condDomiRuc) {
        this.condDomiRuc = condDomiRuc;
    }

    public List<String> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<String> observaciones) {
        this.observaciones = observaciones;
    }
}
