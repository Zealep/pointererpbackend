package com.pointerweb.pointererpbackend.controller;

import com.pointerweb.pointererpbackend.model.Areas;
import com.pointerweb.pointererpbackend.model.Ubigeo;
import com.pointerweb.pointererpbackend.repository.AreasRepository;
import com.pointerweb.pointererpbackend.repository.UbigeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UbigeoController {

    @Autowired
    UbigeoRepository ubigeoRepository;


    @GetMapping(value = "/ubigeo",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ubigeo>> getDatos(){
        try{
            return new ResponseEntity<List<Ubigeo>>((List<Ubigeo>) ubigeoRepository.findAll(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/ubigeo/departamentos",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ubigeo>> getDatosDepartamento(){
        try{
            return new ResponseEntity<List<Ubigeo>>(ubigeoRepository.getDepartamentos(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/ubigeo/provincias/{dep}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ubigeo>> getDatosProvincia(@PathVariable String dep){
        try{
            return new ResponseEntity<List<Ubigeo>>( ubigeoRepository.getProvincias(dep), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/ubigeo/distritos/{dep}/{prov}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ubigeo>> getDatosDistritos(@PathVariable String dep,@PathVariable String prov){
        try{
            return new ResponseEntity<List<Ubigeo>>( ubigeoRepository.getDistritos(dep,prov), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/ubigeo/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ubigeo> getDatosDistritos(@PathVariable String id){
        try{
            return new ResponseEntity<Ubigeo>( ubigeoRepository.findById(id).orElse(null), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
