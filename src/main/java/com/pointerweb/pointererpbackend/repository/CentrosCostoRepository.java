package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.CentrosCosto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentrosCostoRepository extends CrudRepository<CentrosCosto,String> {


    @Query("select c from CentrosCosto c where c.estCentroCosto='ACT'")
    List<CentrosCosto> getActives();
}
