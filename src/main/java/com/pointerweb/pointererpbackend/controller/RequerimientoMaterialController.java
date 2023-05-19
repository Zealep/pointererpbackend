package com.pointerweb.pointererpbackend.controller;

import com.pointerweb.pointererpbackend.model.dto.BandejaReqMaterialInDTO;
import com.pointerweb.pointererpbackend.model.dto.BandejaReqMaterialOutDTO;
import com.pointerweb.pointererpbackend.model.dto.ConsultaValidezInDTO;
import com.pointerweb.pointererpbackend.model.dto.ConsultaValidezOutDTO;
import com.pointerweb.pointererpbackend.service.ConsultaValidezDocumentoService;
import com.pointerweb.pointererpbackend.service.RequerimientoMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequerimientoMaterialController {

    @Autowired
    private RequerimientoMaterialService requerimientoMaterialService;


    @PostMapping(value = "/bandejaReqMaterial",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BandejaReqMaterialOutDTO>> getDatos(@RequestBody BandejaReqMaterialInDTO bandejaReqMaterialInDTO){
        try{
            return new ResponseEntity<List<BandejaReqMaterialOutDTO>>(requerimientoMaterialService.getBandeja(bandejaReqMaterialInDTO), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
