package com.pointerweb.pointererpbackend.model;

import com.pointerweb.pointererpbackend.model.dto.UsuarioModulo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "opcionesmenu")
@SqlResultSetMapping(
        name="getModulosUsuarioMapping",
        classes={
                @ConstructorResult(
                        targetClass= UsuarioModulo.class,
                        columns={
                                @ColumnResult(name="idModulo",type = String.class),
                                @ColumnResult(name="GlsModulo",type = String.class)
                        }
                )
        }
)
@NamedNativeQuery(name="Menu.getModulosUsuario", query="CALL spu_Web_SelModulosUsuarios(:usuario)", resultSetMapping="getModulosUsuarioMapping")
public class Menu implements Serializable {

    @Id
    @Column(name = "opmCod")
    private Long opmCod;

    @Column(name = "opmDes")
    private String opmDes;

    @Column(name = "opmNum")
    private String opmNum;

    @Column(name = "opmIndex")
    private String opmIndex;

    @Column(name = "opmEstado")
    private String opmEstado;

    @Column(name = "idModulo")
    private String idModulo;

    @Column(name = "opmNumPred")
    private String opmNumPred;

    @Column(name = "urlOperacion")
    private String urlOperacion;

    @Transient
    List<Menu> children;

    public Long getOpmCod() {
        return opmCod;
    }

    public void setOpmCod(Long opmCod) {
        this.opmCod = opmCod;
    }

    public String getOpmDes() {
        return opmDes;
    }

    public void setOpmDes(String opmDes) {
        this.opmDes = opmDes;
    }

    public String getOpmEstado() {
        return opmEstado;
    }

    public void setOpmEstado(String opmEstado) {
        this.opmEstado = opmEstado;
    }

    public String getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(String idModulo) {
        this.idModulo = idModulo;
    }

    public String getUrlOperacion() {
        return urlOperacion;
    }

    public void setUrlOperacion(String urlOperacion) {
        this.urlOperacion = urlOperacion;
    }

    public String getOpmNum() {
        return opmNum;
    }

    public void setOpmNum(String opmNum) {
        this.opmNum = opmNum;
    }

    public String getOpmIndex() {
        return opmIndex;
    }

    public void setOpmIndex(String opmIndex) {
        this.opmIndex = opmIndex;
    }

    public String getOpmNumPred() {
        return opmNumPred;
    }

    public void setOpmNumPred(String opmNumPred) {
        this.opmNumPred = opmNumPred;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
