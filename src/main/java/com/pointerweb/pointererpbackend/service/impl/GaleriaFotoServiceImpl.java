package com.pointerweb.pointererpbackend.service.impl;

import com.pointerweb.pointererpbackend.model.GaleriaFoto;
import com.pointerweb.pointererpbackend.repository.DatoArchivoRepository;
import com.pointerweb.pointererpbackend.repository.GaleriaFotoRepository;
import com.pointerweb.pointererpbackend.service.DatoArchivoService;
import com.pointerweb.pointererpbackend.service.GaleriaFotoService;
import com.pointerweb.pointererpbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("galeriaFotoService")
public class GaleriaFotoServiceImpl implements GaleriaFotoService {

    @Autowired
    private GaleriaFotoRepository galeriaFotoRepository;

    @Autowired
    private DatoArchivoRepository datoArchivoRepository;

    @Autowired
    private DatoArchivoService datoArchivoService;

    @Override
    public GaleriaFoto findById(String id) {
        return galeriaFotoRepository.findById(id).orElse(null);
    }

    @Override
    public List<GaleriaFoto> findAll() {
        return galeriaFotoRepository.findActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public GaleriaFoto save(GaleriaFoto d) {

        if(d.getIdGaleriaFoto()==null) {
            String pk = galeriaFotoRepository.generatePrimaryKeyGaleriaFoto(Constantes.TABLE_GALERIA_FOTO, Constantes.ID_TABLE_GALERIA_FOTO, Constantes.CODIGO_EMPRESA);
            d.setIdGaleriaFoto(pk);
        }
        d.setIdEmpresa(Constantes.CODIGO_EMPRESA);
        d.setEstado(Constantes.ESTADO_ACTIVO);

        return galeriaFotoRepository.save(d);
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        galeriaFotoRepository.deleteByIdLogic(id,Constantes.ESTADO_INACTIVO);
    }

    @Override
    @Transactional
    public void deleteAllById(String id) {
        this.deleteById(id);
        datoArchivoService.deleteById(id);
        datoArchivoService.deleteFilesByEntityAndProcess(id,Constantes.PROCESO_GALERIA);
    }
}
