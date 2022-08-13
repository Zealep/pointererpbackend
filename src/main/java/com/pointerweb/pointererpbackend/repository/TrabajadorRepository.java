package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.Areas;
import com.pointerweb.pointererpbackend.model.Trabajador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrabajadorRepository extends CrudRepository<Trabajador,String> {

    @Query("select t from Trabajador t order by t.apePaterno,t.apeMaterno asc")
    List<Trabajador> list();
}
