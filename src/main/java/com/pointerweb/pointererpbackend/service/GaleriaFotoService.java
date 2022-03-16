package com.pointerweb.pointererpbackend.service;

import com.pointerweb.pointererpbackend.model.GaleriaFoto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GaleriaFotoService {

    GaleriaFoto findById(String id);
    List<GaleriaFoto> findAll();
    GaleriaFoto save(GaleriaFoto d);
    void deleteById(String id);
    void deleteAllById(String id);
}
