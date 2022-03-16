package com.pointerweb.pointererpbackend.controller;


import com.pointerweb.pointererpbackend.model.dto.MenuDTO;
import com.pointerweb.pointererpbackend.service.MenuService;
import com.pointerweb.pointererpbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<MenuDTO>> getAll(){
        return new ResponseEntity<>(menuService.findByModulo(Constantes.ID_MODULO), HttpStatus.OK);
    }


}
