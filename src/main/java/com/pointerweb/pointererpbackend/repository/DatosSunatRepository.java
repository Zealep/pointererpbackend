package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.Areas;
import com.pointerweb.pointererpbackend.model.Cargo;
import com.pointerweb.pointererpbackend.model.Datos;
import com.pointerweb.pointererpbackend.model.DatosSunat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatosSunatRepository extends CrudRepository<DatosSunat,String> {

    @Query("select f from DatosSunat f where f.estdatoSunat='ACT'")
    List<DatosSunat> getActives();

    @Query("select d from DatosSunat d where d.codGrupoSunat = ?1 AND d.estdatoSunat = 'ACT'")
    List<DatosSunat> getDatosByCodigoGrupo(String id);

}
