package com.pointerweb.pointererpbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pointerweb.pointererpbackend.model.DatoArchivo;
import com.pointerweb.pointererpbackend.model.Noticia;
import com.pointerweb.pointererpbackend.service.NoticiaService;
import com.pointerweb.pointererpbackend.util.RespuestaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/noticia")
public class NoticiaController {

    @Autowired
    NoticiaService noticiaService;


    @GetMapping(value = "/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Noticia> findById(@PathVariable String id){
        try{
            return new ResponseEntity<Noticia>(noticiaService.findById(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Noticia>> list(){
        try{
            return new ResponseEntity<List<Noticia>>(noticiaService.findAll(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value = "/save",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaApi> save(@RequestParam("detalle") MultipartFile detalle, @RequestParam(value="noticia") String noticia){
        try {
            ObjectMapper obj = new ObjectMapper();
            Noticia n = obj.readValue(noticia,Noticia.class);
            Noticia e = noticiaService.save(n,detalle);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK", e.getIdNoticia(), ""), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaApi> eliminar(@PathVariable String id) {
        try {
            noticiaService.deleteById(id);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK",null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/deleteAll/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaApi> eliminarTodo(@PathVariable String id) {
        try {
            noticiaService.deleteAllById(id);
            return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK",null, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
