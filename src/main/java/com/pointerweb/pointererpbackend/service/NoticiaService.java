package com.pointerweb.pointererpbackend.service;

import com.pointerweb.pointererpbackend.model.Noticia;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface NoticiaService {

    Noticia findById(String id);
    List<Noticia> findAll();
    Noticia save(Noticia d, MultipartFile detalle) throws IOException;
    void deleteById(String id);
    void deleteAllById(String id);
}
