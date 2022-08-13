package com.pointerweb.pointererpbackend.service.impl;

import com.pointerweb.pointererpbackend.model.PruebaRequisicionPersonal;
import com.pointerweb.pointererpbackend.repository.PruebaRequisicionPersonalRepository;
import com.pointerweb.pointererpbackend.service.PruebaRequisicionPersonalService;
import com.pointerweb.pointererpbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("pruebaRequicionPersonalService")
public class PruebaRequisicionPersonalServiceImpl implements PruebaRequisicionPersonalService {

    @Autowired
    private PruebaRequisicionPersonalRepository pruebaRequisicionPersonalRepository;

    @Override
    public List<PruebaRequisicionPersonal> list() {
        return pruebaRequisicionPersonalRepository.getActives();
    }

    @Override
    public List<PruebaRequisicionPersonal> listByRequisicionPersonal(String id) {
        return pruebaRequisicionPersonalRepository.getByRequisicionPersona(id);
    }

    @Override
    @Transactional
    public PruebaRequisicionPersonal save(PruebaRequisicionPersonal p) {

        if(p.getIdReqPerPrueba()==null) {
            String pk = pruebaRequisicionPersonalRepository.generatePrimaryKeyRequisicionPrueba(Constantes.TABLE_PRUEBA_REQUISICION_PERSONAL, Constantes.ID_TABLE_PRUEBA_REQUISICION_PERSONAL, Constantes.CODIGO_EMPRESA);
            p.setIdReqPerPrueba(pk);
        }

        p.setIdEmpresa(Constantes.CODIGO_EMPRESA);
        p.setEstado(Constantes.ESTADO_ACTIVO);
        return pruebaRequisicionPersonalRepository.save(p);
    }

    @Override
    public void saveAll(List<PruebaRequisicionPersonal> p) {
        p.stream().forEach(x->{
            this.save(x);
        });
    }

    @Override
    public PruebaRequisicionPersonal findById(String id) {
        return pruebaRequisicionPersonalRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(String idReq) {
        pruebaRequisicionPersonalRepository.deleteByIdLogic(idReq, Constantes.ESTADO_INACTIVO);
    }
}
