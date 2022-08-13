package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.Cargo;
import com.pointerweb.pointererpbackend.model.PruebaRequisicionPersonal;
import com.pointerweb.pointererpbackend.model.RequisicionPersonal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PruebaRequisicionPersonalRepository extends CrudRepository<PruebaRequisicionPersonal,String> {

    @Query("select f from PruebaRequisicionPersonal f where f.estado='ACT'")
    List<PruebaRequisicionPersonal> getActives();

    @Query("select f from PruebaRequisicionPersonal f where f.idRequisicionPersonal.idRequisicionPersonal=?1 and f.estado='ACT'")
    List<PruebaRequisicionPersonal> getByRequisicionPersona(String id);

    @Procedure(value = "spu_GeneraCorrelativoAnoMes")
    String generatePrimaryKeyRequisicionPrueba(String tabla,String campo,String empresa);


    @Query(value = "update PruebaRequisicionPersonal g set g.estado = ?2 where g.idReqPerPrueba = ?1" )
    @Modifying
    void deleteByIdLogic(String idReq,String inactivo);
}
