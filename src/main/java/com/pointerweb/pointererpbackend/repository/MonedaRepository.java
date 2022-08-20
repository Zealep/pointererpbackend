package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.Documento;
import com.pointerweb.pointererpbackend.model.Moneda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonedaRepository extends CrudRepository<Moneda,String> {

    @Query("select f from Moneda f where f.estMoneda='ACT'")
    List<Moneda> getActives();
}
