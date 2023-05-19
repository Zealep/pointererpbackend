package com.pointerweb.pointererpbackend.service.impl;

import com.pointerweb.pointererpbackend.model.dto.BandejaReqMaterialInDTO;
import com.pointerweb.pointererpbackend.model.dto.BandejaReqMaterialOutDTO;
import com.pointerweb.pointererpbackend.repository.jdbc.RequerimientoMaterialRepository;
import com.pointerweb.pointererpbackend.service.RequerimientoMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("requerimientoMaterialService")
public class RequerimientoMaterialServiceImpl implements RequerimientoMaterialService {

    @Autowired
    private RequerimientoMaterialRepository requerimientoMaterialRepository;

    @Override
    public List<BandejaReqMaterialOutDTO> getBandeja(BandejaReqMaterialInDTO bandejaReqMaterialInDTO) {
        return requerimientoMaterialRepository.bandejaReqMaterial(bandejaReqMaterialInDTO);
    }
}
