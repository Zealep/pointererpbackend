package com.pointerweb.pointererpbackend.service;

import com.pointerweb.pointererpbackend.model.RequisicionPersonal;
import com.pointerweb.pointererpbackend.model.dto.BandejaRequisicionDTO;
import com.pointerweb.pointererpbackend.model.dto.BandejaRequisicionInDTO;

import java.util.List;

public interface RequisicionPersonalService {

    List<RequisicionPersonal> list();

    RequisicionPersonal save(RequisicionPersonal r);

    RequisicionPersonal getById(String id);

    void delete(String id);

    List<BandejaRequisicionDTO> listBandejaRequisicion(BandejaRequisicionInDTO in);
}
