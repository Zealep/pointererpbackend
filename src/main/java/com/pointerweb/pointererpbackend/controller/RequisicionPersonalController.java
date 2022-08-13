package com.pointerweb.pointererpbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pointerweb.pointererpbackend.model.Noticia;
import com.pointerweb.pointererpbackend.model.RequisicionPersonal;
import com.pointerweb.pointererpbackend.model.dto.BandejaRequisicionDTO;
import com.pointerweb.pointererpbackend.model.dto.BandejaRequisicionInDTO;
import com.pointerweb.pointererpbackend.service.NoticiaService;
import com.pointerweb.pointererpbackend.service.RequisicionPersonalService;
import com.pointerweb.pointererpbackend.util.RespuestaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/requisicion")
public class RequisicionPersonalController {

    @Autowired
    RequisicionPersonalService requisicionPersonalService;


    @GetMapping(value = "/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RequisicionPersonal> findById(@PathVariable String id){
        try{
            return new ResponseEntity<RequisicionPersonal>(requisicionPersonalService.getById(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RequisicionPersonal>> list(){
        try{
            return new ResponseEntity<List<RequisicionPersonal>>(requisicionPersonalService.list(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/bandeja",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BandejaRequisicionDTO>> bandeja(@RequestBody BandejaRequisicionInDTO bandejaRequisicionInDTO){
        try{
            return new ResponseEntity<List<BandejaRequisicionDTO>>(requisicionPersonalService.listBandejaRequisicion(bandejaRequisicionInDTO), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaApi> save(@RequestBody RequisicionPersonal requisicionPersonal){
        try {

            RequisicionPersonal e = requisicionPersonalService.save(requisicionPersonal);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK", e.getIdRequisicionPersonal(), ""), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping(value = "/cerrar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaApi> eliminar(@PathVariable String id) {
        try {
            requisicionPersonalService.delete(id);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK",null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
