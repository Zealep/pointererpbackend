package com.pointerweb.pointererpbackend.service;

import com.pointerweb.pointererpbackend.model.PruebaRequisicionPersonal;

import java.util.List;

public interface PruebaRequisicionPersonalService {

    List<PruebaRequisicionPersonal> list();

    List<PruebaRequisicionPersonal> listByRequisicionPersonal(String id);
    PruebaRequisicionPersonal save(PruebaRequisicionPersonal p);

    void saveAll(List<PruebaRequisicionPersonal> p);
    PruebaRequisicionPersonal findById(String id);
    void delete(String idReq);
}
