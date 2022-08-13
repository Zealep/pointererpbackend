package com.pointerweb.pointererpbackend.service.impl;

import com.pointerweb.pointererpbackend.model.RequisicionPersonal;
import com.pointerweb.pointererpbackend.model.dto.BandejaRequisicionDTO;
import com.pointerweb.pointererpbackend.model.dto.BandejaRequisicionInDTO;
import com.pointerweb.pointererpbackend.repository.RequisicionPersonalRepository;
import com.pointerweb.pointererpbackend.repository.jdbc.BandejaRequisicionRepository;
import com.pointerweb.pointererpbackend.service.RequisicionPersonalService;
import com.pointerweb.pointererpbackend.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("requisicionPersonalService")
public class RequisicionPersonalServiceImpl implements RequisicionPersonalService {

    @Autowired
    RequisicionPersonalRepository requisicionPersonalRepository;

    @Autowired
    BandejaRequisicionRepository bandejaRequisicionRepository;

    @Override
    public List<RequisicionPersonal> list() {
        return requisicionPersonalRepository.getActives();
    }

    @Override
    @Transactional
    public RequisicionPersonal save(RequisicionPersonal r) {

        if(r.getIdRequisicionPersonal()==null) {
            String pk = requisicionPersonalRepository.generatePrimaryKeyRequisicion(Constantes.TABLE_REQUISICION_PERSONAL, Constantes.ID_TABLE_REQUISICION_PERSONAL, Constantes.CODIGO_EMPRESA);
            r.setIdRequisicionPersonal(pk);
        }

        r.setIdEmpresa(Constantes.CODIGO_EMPRESA);

        return requisicionPersonalRepository.save(r);
    }

    @Override
    public RequisicionPersonal getById(String id) {
        return requisicionPersonalRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(String id) {
        requisicionPersonalRepository.deleteByIdLogic(id,Constantes.REQUISICION_CERRADA);
    }

    @Override
    public List<BandejaRequisicionDTO> listBandejaRequisicion(BandejaRequisicionInDTO in) {
        return bandejaRequisicionRepository.listRequisicion(in);
    }
}
