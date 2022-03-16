package com.pointerweb.pointererpbackend.controller;

import com.pointerweb.pointererpbackend.model.GaleriaFoto;
import com.pointerweb.pointererpbackend.service.GaleriaFotoService;
import com.pointerweb.pointererpbackend.util.RespuestaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/galeria")
public class GaleriaFotoController {

    @Autowired
    GaleriaFotoService galeriaFotoService;


    @GetMapping(value = "/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GaleriaFoto> findById(@PathVariable String id){
        try{
            return new ResponseEntity<GaleriaFoto>(galeriaFotoService.findById(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GaleriaFoto>> list(){
        try{
            return new ResponseEntity<List<GaleriaFoto>>((List<GaleriaFoto>) galeriaFotoService.findAll(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaApi> save(@RequestBody GaleriaFoto galeriaFoto){
        try {
            GaleriaFoto e = galeriaFotoService.save(galeriaFoto);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK", e.getIdGaleriaFoto(), ""), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaApi> eliminar(@PathVariable String id) {
        try {
            galeriaFotoService.deleteById(id);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK",null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/deleteAll/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaApi> eliminarTodo(@PathVariable String id) {
        try {
            galeriaFotoService.deleteAllById(id);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK",null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
