package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.Datos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatosRepository extends CrudRepository<Datos,String> {

    @Query("select d from Datos d where d.idTipoDatos = ?1 AND d.estDato = 'ACT'")
    List<Datos> getDatosByIdTipoDatos(String id);

}
