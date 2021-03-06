package com.pointerweb.pointererpbackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rh_in_tz_noticia")
public class Noticia {

    @Id
    @Column(name = "idNoticia")
    private String idNoticia;

    @Column(name = "idEmpresa")
    private String idEmpresa;

    @Column(name = "titulo")
    private String titulo;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "detalle",length=100000)
    private byte[] detalle;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "estado")
    private String estado;

    @Transient
    private String imagen;

    @Transient
    private String detalleHtml;


    public String getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(String idNoticia) {
        this.idNoticia = idNoticia;
    }

    public byte[] getDetalle() {
        return detalle;
    }

    public void setDetalle(byte[] detalle) {
        this.detalle = detalle;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDetalleHtml() {
        return detalleHtml;
    }

    public void setDetalleHtml(String detalleHtml) {
        this.detalleHtml = detalleHtml;
    }
}
