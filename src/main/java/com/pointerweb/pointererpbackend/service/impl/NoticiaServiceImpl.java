package com.pointerweb.pointererpbackend.service.impl;

import com.pointerweb.pointererpbackend.model.GaleriaFoto;
import com.pointerweb.pointererpbackend.model.Noticia;
import com.pointerweb.pointererpbackend.repository.DatoArchivoRepository;
import com.pointerweb.pointererpbackend.repository.GaleriaFotoRepository;
import com.pointerweb.pointererpbackend.repository.NoticiaRepository;
import com.pointerweb.pointererpbackend.service.DatoArchivoService;
import com.pointerweb.pointererpbackend.service.GaleriaFotoService;
import com.pointerweb.pointererpbackend.service.NoticiaService;
import com.pointerweb.pointererpbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service("noticiaService")
public class NoticiaServiceImpl implements NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @Autowired
    private DatoArchivoRepository datoArchivoRepository;

    @Autowired
    private DatoArchivoService datoArchivoService;

    @Override
    public Noticia findById(String id) {
        Noticia n = noticiaRepository.findById(id).orElse(null);
        n.setDetalleHtml(new String(n.getDetalle()));
        return n;
    }

    @Override
    public List<Noticia> findAll() {
        return noticiaRepository.findActives(Constantes.ESTADO_ACTIVO);
    }

    @Override
    public Noticia save(Noticia d, MultipartFile detalle)  {
        try {

        d.setDetalle(detalle.getBytes());
        if(d.getIdNoticia()==null) {
            String pk = noticiaRepository.generatePrimaryKeyNoticia(Constantes.TABLE_NOTICIA, Constantes.ID_TABLE_NOTICIA, Constantes.CODIGO_EMPRESA);
            d.setIdNoticia(pk);
        }

        d.setIdEmpresa(Constantes.CODIGO_EMPRESA);
        d.setEstado(Constantes.ESTADO_ACTIVO);
        }
        catch (Exception e){

        }
        return noticiaRepository.save(d);
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        noticiaRepository.deleteByIdLogic(id,Constantes.ESTADO_INACTIVO);
    }

    @Override
    @Transactional
    public void deleteAllById(String id) {
        try {
            this.deleteById(id);
            datoArchivoService.deleteById(id);
            datoArchivoService.deleteFilesByEntityAndProcess(id,Constantes.PROCESO_NOTICIA);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
