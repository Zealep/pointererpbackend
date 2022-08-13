package com.pointerweb.pointererpbackend.service.impl;

import com.pointerweb.pointererpbackend.model.Datos;
import com.pointerweb.pointererpbackend.repository.DatosRepository;
import com.pointerweb.pointererpbackend.service.DatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("datosService")
public class DatosServiceImpl implements DatosService {

    @Autowired
    DatosRepository datosRepository;

    @Override
    public List<Datos> getDatosByIdTipoDato(String id) {
        return datosRepository.getDatosByIdTipoDatos(id);
    }
}
