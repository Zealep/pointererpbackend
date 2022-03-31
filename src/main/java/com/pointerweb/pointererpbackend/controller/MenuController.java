package com.pointerweb.pointererpbackend.controller;


import com.pointerweb.pointererpbackend.model.Menu;
import com.pointerweb.pointererpbackend.model.dto.MenuDTO;
import com.pointerweb.pointererpbackend.model.dto.UsuarioModulo;
import com.pointerweb.pointererpbackend.repository.MenuRepository;
import com.pointerweb.pointererpbackend.service.MenuService;
import com.pointerweb.pointererpbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @Autowired
    MenuRepository menuRepository;

    @GetMapping(value = "/list/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<MenuDTO>> getAllByModulo(@PathVariable String id){
        return new ResponseEntity<>(menuService.findByModulo(id), HttpStatus.OK);
    }

    @GetMapping(value = "/principales", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Menu>> getPrincipales(){
        return new ResponseEntity<List<Menu>>(menuRepository.findByModuloPrincipal(Constantes.ID_MODULO).orElse(null), HttpStatus.OK);
    }

    @GetMapping(value = "/usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<UsuarioModulo>> getPrincipales(@PathVariable String id){
        return new ResponseEntity<List<UsuarioModulo>>(menuRepository.getModulosUsuario(id), HttpStatus.OK);
    }


}
