package com.pointerweb.pointererpbackend.model.dto;

import java.util.Date;

public class BandejaRequisicionInDTO {
    private Date fechaSolicitudDesde;
    private Date fechaSolicitudHasta;
    private String codigoRequisicion;
    private String idCargo;
    private String idCentroCostoSolicitante;
    private String idAreaSolicitante;

    public Date getFechaSolicitudDesde() {
        return fechaSolicitudDesde;
    }

    public void setFechaSolicitudDesde(Date fechaSolicitudDesde) {
        this.fechaSolicitudDesde = fechaSolicitudDesde;
    }

    public Date getFechaSolicitudHasta() {
        return fechaSolicitudHasta;
    }

    public void setFechaSolicitudHasta(Date fechaSolicitudHasta) {
        this.fechaSolicitudHasta = fechaSolicitudHasta;
    }

    public String getCodigoRequisicion() {
        return codigoRequisicion;
    }

    public void setCodigoRequisicion(String codigoRequisicion) {
        this.codigoRequisicion = codigoRequisicion;
    }

    public String getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(String idCargo) {
        this.idCargo = idCargo;
    }

    public String getIdCentroCostoSolicitante() {
        return idCentroCostoSolicitante;
    }

    public void setIdCentroCostoSolicitante(String idCentroCostoSolicitante) {
        this.idCentroCostoSolicitante = idCentroCostoSolicitante;
    }

    public String getIdAreaSolicitante() {
        return idAreaSolicitante;
    }

    public void setIdAreaSolicitante(String idAreaSolicitante) {
        this.idAreaSolicitante = idAreaSolicitante;
    }
}
