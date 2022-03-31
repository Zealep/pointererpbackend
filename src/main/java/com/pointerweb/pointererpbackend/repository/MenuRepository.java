package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.Menu;
import com.pointerweb.pointererpbackend.model.dto.UsuarioModulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends CrudRepository<Menu,Long> {

    @Query("select u from Menu u where u.idModulo=?1")
    Optional<List<Menu>> findByModulo(String modulo);

    @Query("select u from Menu u where u.idModulo=?1 and u.opmNumPred=''")
    Optional<List<Menu>> findByModuloPrincipal(String modulo);

    @Query(nativeQuery = true)
    List<UsuarioModulo> getModulosUsuario(@Param("usuario") String usuario);

}
