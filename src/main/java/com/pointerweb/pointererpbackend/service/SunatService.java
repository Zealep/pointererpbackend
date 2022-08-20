package com.pointerweb.pointererpbackend.service;

import com.pointerweb.pointererpbackend.model.dto.sunat.SunatTokenResponse;
import com.pointerweb.pointererpbackend.model.dto.sunat.SunatValidarDocumentoRequest;
import com.pointerweb.pointererpbackend.model.dto.sunat.SunatValidarDocumentoResponse;

public interface SunatService {

    SunatTokenResponse token();
    SunatValidarDocumentoResponse validarDocumento(SunatValidarDocumentoRequest sunatValidarDocumentoRequest);


}
