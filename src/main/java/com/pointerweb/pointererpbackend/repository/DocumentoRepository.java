package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.Areas;
import com.pointerweb.pointererpbackend.model.Cargo;
import com.pointerweb.pointererpbackend.model.Documento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoRepository extends CrudRepository<Documento,String> {

    @Query("select f from Documento f where f.estDocumentos='ACT'")
    List<Documento> getActives();
}
