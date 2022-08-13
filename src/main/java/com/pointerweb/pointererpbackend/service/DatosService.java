package com.pointerweb.pointererpbackend.service;

import com.pointerweb.pointererpbackend.model.Datos;

import java.util.List;

public interface DatosService {

    List<Datos> getDatosByIdTipoDato(String id);
}
