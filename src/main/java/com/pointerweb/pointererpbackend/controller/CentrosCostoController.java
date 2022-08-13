package com.pointerweb.pointererpbackend.controller;

import com.pointerweb.pointererpbackend.model.Cargo;
import com.pointerweb.pointererpbackend.model.CentrosCosto;
import com.pointerweb.pointererpbackend.repository.CargoRepository;
import com.pointerweb.pointererpbackend.repository.CentrosCostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CentrosCostoController {

    @Autowired
    CentrosCostoRepository centrosCostoRepository;


    @GetMapping(value = "/centroscosto",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CentrosCosto>> getDatos(){
        try{
            return new ResponseEntity<List<CentrosCosto>>(centrosCostoRepository.getActives(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
