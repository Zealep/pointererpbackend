package com.pointerweb.pointererpbackend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rh_rl_reqper_prueba")
public class PruebaRequisicionPersonal {

    @Id
    private String idReqPerPrueba;

    @ManyToOne
    @JoinColumn(name="idRequisicionPersonal",referencedColumnName="idRequisicionPersonal")
    private RequisicionPersonal idRequisicionPersonal;

    @ManyToOne
    @JoinColumn(name="idDatoTipoPrueba",referencedColumnName="idDato")
    private Datos idDatoTipoPrueba;

    @Column(name = "idEmpresa")
    private String idEmpresa;

    @Column(name = "pesoPrueba")
    private Integer pesoPrueba;

    @Column(name = "estado")
    private String estado;

    @Column(name = "usCreacion")
    private String usCreacion;

    @Column(name = "feCreacion")
    private Date feCreacion;

    @Column(name = "ipCreacion")
    private String ipCreacion;

    @Column(name = "usModificacion")
    private String usModificacion;

    @Column(name = "feModificacion")
    private Date feModificacion;

    @Column(name = "ipModificacion")
    private String ipModificacion;


    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getIdReqPerPrueba() {
        return idReqPerPrueba;
    }

    public void setIdReqPerPrueba(String idReqPerPrueba) {
        this.idReqPerPrueba = idReqPerPrueba;
    }

    public RequisicionPersonal getIdRequisicionPersonal() {
        return idRequisicionPersonal;
    }

    public void setIdRequisicionPersonal(RequisicionPersonal idRequisicionPersonal) {
        this.idRequisicionPersonal = idRequisicionPersonal;
    }

    public Datos getIdDatoTipoPrueba() {
        return idDatoTipoPrueba;
    }

    public void setIdDatoTipoPrueba(Datos idDatoTipoPrueba) {
        this.idDatoTipoPrueba = idDatoTipoPrueba;
    }

    public Integer getPesoPrueba() {
        return pesoPrueba;
    }

    public void setPesoPrueba(Integer pesoPrueba) {
        this.pesoPrueba = pesoPrueba;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsCreacion() {
        return usCreacion;
    }

    public void setUsCreacion(String usCreacion) {
        this.usCreacion = usCreacion;
    }

    public Date getFeCreacion() {
        return feCreacion;
    }

    public void setFeCreacion(Date feCreacion) {
        this.feCreacion = feCreacion;
    }

    public String getIpCreacion() {
        return ipCreacion;
    }

    public void setIpCreacion(String ipCreacion) {
        this.ipCreacion = ipCreacion;
    }

    public String getUsModificacion() {
        return usModificacion;
    }

    public void setUsModificacion(String usModificacion) {
        this.usModificacion = usModificacion;
    }

    public Date getFeModificacion() {
        return feModificacion;
    }

    public void setFeModificacion(Date feModificacion) {
        this.feModificacion = feModificacion;
    }

    public String getIpModificacion() {
        return ipModificacion;
    }

    public void setIpModificacion(String ipModificacion) {
        this.ipModificacion = ipModificacion;
    }
}
