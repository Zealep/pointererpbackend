package com.pointerweb.pointererpbackend.service;

import com.pointerweb.pointererpbackend.model.dto.BandejaReqMaterialInDTO;
import com.pointerweb.pointererpbackend.model.dto.BandejaReqMaterialOutDTO;

import java.util.List;

public interface RequerimientoMaterialService {

    List<BandejaReqMaterialOutDTO> getBandeja(BandejaReqMaterialInDTO bandejaReqMaterialInDTO);
}
