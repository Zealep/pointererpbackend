package com.pointerweb.pointererpbackend.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ConsultaValidezOutDTO {

    private String nroAuxiliar;
    private String tipoDocumento;
    private String serie;
    private String numero;
    private String nroDocumentoProveedor;
    private String razonSocialProveedor;
    private String fechaEmision;
    private String fechaContable;
    private String moneda;
    private BigDecimal base;
    private BigDecimal exonerado;
    private BigDecimal igv;
    private BigDecimal total;
    private String estado;
    private String idDatoSunat;
    private String idSunatEstadoDocumento;
    private String idSunatEstadoProveedor;
    private String idSunatEstadoDomicilioProveedor;
    private String idDocumento;
    private String glsRuc;
    private String idRegistroCompra;
    private BigDecimal totalPrecioCompra;

    public String getIdRegistroCompra() {
        return idRegistroCompra;
    }

    public void setIdRegistroCompra(String idRegistroCompra) {
        this.idRegistroCompra = idRegistroCompra;
    }

    public String getNroAuxiliar() {
        return nroAuxiliar;
    }

    public void setNroAuxiliar(String nroAuxiliar) {
        this.nroAuxiliar = nroAuxiliar;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNroDocumentoProveedor() {
        return nroDocumentoProveedor;
    }

    public void setNroDocumentoProveedor(String nroDocumentoProveedor) {
        this.nroDocumentoProveedor = nroDocumentoProveedor;
    }

    public String getRazonSocialProveedor() {
        return razonSocialProveedor;
    }

    public void setRazonSocialProveedor(String razonSocialProveedor) {
        this.razonSocialProveedor = razonSocialProveedor;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaContable() {
        return fechaContable;
    }

    public void setFechaContable(String fechaContable) {
        this.fechaContable = fechaContable;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public BigDecimal getExonerado() {
        return exonerado;
    }

    public void setExonerado(BigDecimal exonerado) {
        this.exonerado = exonerado;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdDatoSunat() {
        return idDatoSunat;
    }

    public void setIdDatoSunat(String idDatoSunat) {
        this.idDatoSunat = idDatoSunat;
    }

    public String getIdSunatEstadoDocumento() {
        return idSunatEstadoDocumento;
    }

    public void setIdSunatEstadoDocumento(String idSunatEstadoDocumento) {
        this.idSunatEstadoDocumento = idSunatEstadoDocumento;
    }

    public String getIdSunatEstadoProveedor() {
        return idSunatEstadoProveedor;
    }

    public void setIdSunatEstadoProveedor(String idSunatEstadoProveedor) {
        this.idSunatEstadoProveedor = idSunatEstadoProveedor;
    }

    public String getIdSunatEstadoDomicilioProveedor() {
        return idSunatEstadoDomicilioProveedor;
    }

    public void setIdSunatEstadoDomicilioProveedor(String idSunatEstadoDomicilioProveedor) {
        this.idSunatEstadoDomicilioProveedor = idSunatEstadoDomicilioProveedor;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public BigDecimal getTotalPrecioCompra() {
        return totalPrecioCompra;
    }

    public void setTotalPrecioCompra(BigDecimal totalPrecioCompra) {
        this.totalPrecioCompra = totalPrecioCompra;
    }

    public String getGlsRuc() {
        return glsRuc;
    }

    public void setGlsRuc(String glsRuc) {
        this.glsRuc = glsRuc;
    }
}
