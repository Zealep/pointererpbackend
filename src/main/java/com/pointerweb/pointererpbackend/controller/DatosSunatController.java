package com.pointerweb.pointererpbackend.controller;

import com.pointerweb.pointererpbackend.model.Datos;
import com.pointerweb.pointererpbackend.model.DatosSunat;
import com.pointerweb.pointererpbackend.repository.DatosSunatRepository;
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
public class DatosSunatController {

    @Autowired
    DatosSunatRepository datosSunatRepository;


    @GetMapping(value = "/datossunat/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DatosSunat>> getDatosByCodigoGrupo(@PathVariable String id){
        try{
            return new ResponseEntity<List<DatosSunat>>(datosSunatRepository.getDatosByCodigoGrupo(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/datossunat",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DatosSunat>> getDatos(){
        try{
            return new ResponseEntity<List<DatosSunat>>(datosSunatRepository.getActives(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
