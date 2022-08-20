package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.Documento;
import com.pointerweb.pointererpbackend.model.Moneda;
import com.pointerweb.pointererpbackend.model.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends CrudRepository<Persona,String> {

    @Query("select f from Persona f where f.estPersona='ACT'")
    List<Persona> getActives();
}
