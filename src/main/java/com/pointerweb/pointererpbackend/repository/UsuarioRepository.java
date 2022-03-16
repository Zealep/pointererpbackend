package com.pointerweb.pointererpbackend.repository;

import com.pointerweb.pointererpbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String> {


    @Query("select u from Usuario u where u.usuario=?1")
    Optional<Usuario> findByUsername(String username);

    @Query("select u.password from Usuario u where u.usuario=?1")
    String findPassByUsuario(String email);

    @Query("select u.idUsuario from Usuario u where u.usuario=?1")
    String findIdUsuarioByUsername(String usuario);


}
