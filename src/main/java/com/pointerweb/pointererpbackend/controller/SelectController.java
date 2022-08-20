package com.pointerweb.pointererpbackend.controller;

import com.pointerweb.pointererpbackend.model.Areas;
import com.pointerweb.pointererpbackend.model.Documento;
import com.pointerweb.pointererpbackend.model.Moneda;
import com.pointerweb.pointererpbackend.model.Persona;
import com.pointerweb.pointererpbackend.model.dto.AlertasInDTO;
import com.pointerweb.pointererpbackend.model.dto.AlertasOutDTO;
import com.pointerweb.pointererpbackend.repository.DocumentoRepository;
import com.pointerweb.pointererpbackend.repository.MonedaRepository;
import com.pointerweb.pointererpbackend.repository.PersonaRepository;
import com.pointerweb.pointererpbackend.repository.jdbc.AlertaRepository;
import com.pointerweb.pointererpbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("select")
public class SelectController {

    @Autowired
    private MonedaRepository monedaRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private AlertaRepository alertaRepository;

    @GetMapping(value = "/proveedor",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Persona>> getProveedores(){
        try{
            return new ResponseEntity<List<Persona>>( personaRepository.getActives(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/moneda",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Moneda>> getMonedas(){
        try{
            return new ResponseEntity<List<Moneda>>( monedaRepository.getActives(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/documento",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Documento>> getDocumentos(){
        try{
            return new ResponseEntity<List<Documento>>( documentoRepository.getActives(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/alertas/{usuario}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlertasOutDTO>> getAlertas(@PathVariable String usuario){
        try{
            AlertasInDTO alertasInDTO = new AlertasInDTO();
            alertasInDTO.setIdEmpresa(Constantes.CODIGO_EMPRESA);
            alertasInDTO.setIdUsuario(usuario);
            return new ResponseEntity<List<AlertasOutDTO>>( alertaRepository.listAlertas(alertasInDTO), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
