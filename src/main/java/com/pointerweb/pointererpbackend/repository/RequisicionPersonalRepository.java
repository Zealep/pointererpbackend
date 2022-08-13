package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.Areas;
import com.pointerweb.pointererpbackend.model.RequisicionPersonal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequisicionPersonalRepository extends CrudRepository<RequisicionPersonal,String> {

    @Query("select f from RequisicionPersonal f where f.estRequisicion='ACT'")
    List<RequisicionPersonal> getActives();

    @Procedure(value = "spu_GeneraCorrelativoAnoMes")
    String generatePrimaryKeyRequisicion(String tabla,String campo,String empresa);

    @Query(value = "update RequisicionPersonal g set g.estRequisicion = ?2 where g.idRequisicionPersonal = ?1")
    @Modifying
    void deleteByIdLogic(String id,String inactivo);
}
