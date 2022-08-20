package com.pointerweb.pointererpbackend.controller;

import com.pointerweb.pointererpbackend.model.dto.sunat.SunatTokenResponse;
import com.pointerweb.pointererpbackend.model.dto.sunat.SunatValidarDocumentoRequest;
import com.pointerweb.pointererpbackend.model.dto.sunat.SunatValidarDocumentoResponse;
import com.pointerweb.pointererpbackend.service.SunatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping("sunat")
public class SunatController {

    @Autowired
    SunatService sunatService;

    @GetMapping(value = "/token")
    private ResponseEntity<SunatTokenResponse> token(){
    try {
        return new ResponseEntity<>(sunatService.token(),HttpStatus.OK);
    }
    catch (Exception ex){
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }

    @PostMapping(value = "/validarComprobante",consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<SunatValidarDocumentoResponse> validarComprobante(@RequestBody SunatValidarDocumentoRequest request){
        try {
            return new ResponseEntity<>(sunatService.validarDocumento(request),HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
