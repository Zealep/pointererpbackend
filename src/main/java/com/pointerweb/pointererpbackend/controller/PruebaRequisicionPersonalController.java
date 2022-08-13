package com.pointerweb.pointererpbackend.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pointerweb.pointererpbackend.model.PruebaRequisicionPersonal;
import com.pointerweb.pointererpbackend.model.RequisicionPersonal;
import com.pointerweb.pointererpbackend.model.dto.BandejaRequisicionDTO;
import com.pointerweb.pointererpbackend.model.dto.BandejaRequisicionInDTO;
import com.pointerweb.pointererpbackend.service.PruebaRequisicionPersonalService;
import com.pointerweb.pointererpbackend.service.RequisicionPersonalService;
import com.pointerweb.pointererpbackend.util.RespuestaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pruebaRequisicion")
public class PruebaRequisicionPersonalController {

    @Autowired
    PruebaRequisicionPersonalService pruebaRequisicionPersonalService;


    @GetMapping(value = "/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PruebaRequisicionPersonal> findById(@PathVariable String id){
        try{
            return new ResponseEntity<PruebaRequisicionPersonal>(pruebaRequisicionPersonalService.findById(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/findByRequisicion/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PruebaRequisicionPersonal>> findByIdRequisicion(@PathVariable String id){
        try{
            return new ResponseEntity<List<PruebaRequisicionPersonal>>(pruebaRequisicionPersonalService.listByRequisicionPersonal(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PruebaRequisicionPersonal>> list(){
        try{
            return new ResponseEntity<List<PruebaRequisicionPersonal>>(pruebaRequisicionPersonalService.list(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaApi> save(@RequestBody PruebaRequisicionPersonal requisicionPersonal){
        try {

            PruebaRequisicionPersonal e = pruebaRequisicionPersonalService.save(requisicionPersonal);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK", e.getIdReqPerPrueba(), ""), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/saveAll",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaApi> save(@RequestParam(value="pruebas") String pruebas){
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<PruebaRequisicionPersonal> myObjects = mapper.readValue(pruebas, new TypeReference<List<PruebaRequisicionPersonal>>(){});
            pruebaRequisicionPersonalService.saveAll(myObjects);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK","", ""), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{idReq}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaApi> eliminar(@PathVariable String idReq) {
        try {
            pruebaRequisicionPersonalService.delete(idReq);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK",null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
