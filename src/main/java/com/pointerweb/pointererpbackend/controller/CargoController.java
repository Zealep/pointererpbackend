package com.pointerweb.pointererpbackend.controller;

import com.pointerweb.pointererpbackend.model.Areas;
import com.pointerweb.pointererpbackend.model.Cargo;
import com.pointerweb.pointererpbackend.repository.AreasRepository;
import com.pointerweb.pointererpbackend.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CargoController {

    @Autowired
    CargoRepository cargoRepository;


    @GetMapping(value = "/cargo",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cargo>> getDatos(){
        try{
            return new ResponseEntity<List<Cargo>>((List<Cargo>) cargoRepository.findAll(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
