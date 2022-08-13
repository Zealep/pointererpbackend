package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.Cargo;
import com.pointerweb.pointererpbackend.model.Datos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends CrudRepository<Cargo,String> {

}
