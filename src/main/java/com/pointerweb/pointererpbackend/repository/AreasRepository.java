package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.Areas;
import com.pointerweb.pointererpbackend.model.Cargo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreasRepository extends CrudRepository<Areas,String> {

    @Query("select f from Areas f where f.estArea='ACT'")
    List<Areas> getActives();
}
