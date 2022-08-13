package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.Datos;
import com.pointerweb.pointererpbackend.model.Ubigeo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbigeoRepository extends CrudRepository<Ubigeo,String> {

    @Query("select u from Ubigeo u where u.idProv= '00' and u.idDist = '00'")
    List<Ubigeo> getDepartamentos();

    @Query("select u from Ubigeo u where u.idDpto=?1 and u.idDist = '00'")
    List<Ubigeo> getProvincias(String idDepartamento);

    @Query("select u from Ubigeo u where u.idDpto=?1 and u.idProv=?2")
    List<Ubigeo> getDistritos(String idDepartamento,String idProvincia);

}
