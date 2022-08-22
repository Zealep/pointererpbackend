package com.pointerweb.pointererpbackend.controller;

import com.pointerweb.pointererpbackend.model.Areas;
import com.pointerweb.pointererpbackend.model.dto.ConsultaValidezInDTO;
import com.pointerweb.pointererpbackend.model.dto.ConsultaValidezOutDTO;
import com.pointerweb.pointererpbackend.repository.AreasRepository;
import com.pointerweb.pointererpbackend.repository.jdbc.ConsultaValidezDocumentosRepository;
import com.pointerweb.pointererpbackend.service.ConsultaValidezDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaValidezController {

    @Autowired
    ConsultaValidezDocumentoService consultaValidezDocumentoService;


    @PostMapping(value = "/bandejaConsultaValidez",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConsultaValidezOutDTO>> getDatos(@RequestBody ConsultaValidezInDTO consultaValidezInDTO){
        try{
            return new ResponseEntity<List<ConsultaValidezOutDTO>>(consultaValidezDocumentoService.bandejaConsultaPointer(consultaValidezInDTO), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/bandejaConsultaValidezSunat",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConsultaValidezOutDTO>> getDatosSunat(@RequestBody ConsultaValidezInDTO consultaValidezInDTO){
        try{
            return new ResponseEntity<List<ConsultaValidezOutDTO>>(consultaValidezDocumentoService.bandejaConsultaSunat(consultaValidezInDTO), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
