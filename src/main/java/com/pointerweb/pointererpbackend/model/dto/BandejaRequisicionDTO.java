package com.pointerweb.pointererpbackend.model.dto;

import java.util.Date;

public class BandejaRequisicionDTO {

    private String idRequisicionPersonal;
    private Date fechaSolicitud;
    private String idCargo;
    private String glsCargo;
    private String estRequisicion;

    public String getIdRequisicionPersonal() {
        return idRequisicionPersonal;
    }

    public void setIdRequisicionPersonal(String idRequisicionPersonal) {
        this.idRequisicionPersonal = idRequisicionPersonal;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(String idCargo) {
        this.idCargo = idCargo;
    }

    public String getGlsCargo() {
        return glsCargo;
    }

    public void setGlsCargo(String glsCargo) {
        this.glsCargo = glsCargo;
    }

    public String getEstRequisicion() {
        return estRequisicion;
    }

    public void setEstRequisicion(String estRequisicion) {
        this.estRequisicion = estRequisicion;
    }
}
