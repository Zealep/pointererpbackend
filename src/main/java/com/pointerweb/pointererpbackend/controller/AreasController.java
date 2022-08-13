package com.pointerweb.pointererpbackend.controller;

import com.pointerweb.pointererpbackend.model.Areas;
import com.pointerweb.pointererpbackend.model.Datos;
import com.pointerweb.pointererpbackend.repository.AreasRepository;
import com.pointerweb.pointererpbackend.service.DatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AreasController {

    @Autowired
    AreasRepository areasRepository;


    @GetMapping(value = "/areas",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Areas>> getDatos(){
        try{
            return new ResponseEntity<List<Areas>>(areasRepository.getActives(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
