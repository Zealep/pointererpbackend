package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.GaleriaFoto;
import com.pointerweb.pointererpbackend.model.Noticia;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends CrudRepository<Noticia,String> {

    @Procedure(value = "spu_GeneraCorrelativoAnoMes")
    String generatePrimaryKeyNoticia(String tabla,String campo,String empresa);

    @Query(value = "select g from Noticia g where g.estado = ?1")
    List<Noticia> findActives(String activos);

    @Query(value = "update Noticia g set g.estado = ?2 where g.idNoticia = ?1")
    @Modifying
    void deleteByIdLogic(String id,String inactivo);
}
