package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.DatoArchivo;
import com.pointerweb.pointererpbackend.model.GaleriaFoto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GaleriaFotoRepository extends CrudRepository<GaleriaFoto,String> {

    @Procedure(value = "spu_GeneraCorrelativoAnoMes")
    String generatePrimaryKeyGaleriaFoto(String tabla,String campo,String empresa);

    @Query(value = "select g from GaleriaFoto g where g.estado = ?1")
    List<GaleriaFoto> findActives(String activos);

    @Query(value = "update GaleriaFoto g set g.estado = ?2 where g.idGaleriaFoto = ?1")
    @Modifying
    void deleteByIdLogic(String id,String inactivo);
}
