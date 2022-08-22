package com.pointerweb.pointererpbackend.service.impl;

import com.pointerweb.pointererpbackend.model.dto.ConsultaValidezInDTO;
import com.pointerweb.pointererpbackend.model.dto.ConsultaValidezOutDTO;
import com.pointerweb.pointererpbackend.model.dto.sunat.SunatValidarDocumentoRequest;
import com.pointerweb.pointererpbackend.model.dto.sunat.SunatValidarDocumentoResponse;
import com.pointerweb.pointererpbackend.repository.jdbc.ConsultaValidezDocumentosRepository;
import com.pointerweb.pointererpbackend.service.ConsultaValidezDocumentoService;
import com.pointerweb.pointererpbackend.service.SunatService;
import com.pointerweb.pointererpbackend.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("consultaValidezDocumentoService")
public class ConsultaValidezDocumentoServiceImpl implements ConsultaValidezDocumentoService {

    @Autowired
    ConsultaValidezDocumentosRepository consultaValidezDocumentosRepository;

    @Autowired
    SunatService sunatService;

    @Override
    public List<ConsultaValidezOutDTO> bandejaConsultaSunat(ConsultaValidezInDTO consultaValidezInDTO) {
        List<ConsultaValidezOutDTO> bandejaPointer = consultaValidezDocumentosRepository.bandejaConsultaValidez(consultaValidezInDTO);

        for(ConsultaValidezOutDTO c:bandejaPointer){

            if(c.getIdSunatEstadoDocumento() != null){
                if(c.getIdSunatEstadoDocumento().equals("0") || c.getIdSunatEstadoDocumento().equals("")){
                    SunatValidarDocumentoResponse s = this.consultarDatosSunat(c);
                    this.insertarDatosSunat(s,c.getIdRegistroCompra());
                }
                else{
                    continue;
                }
            }
            else{
                SunatValidarDocumentoResponse s = this.consultarDatosSunat(c);
                this.insertarDatosSunat(s,c.getIdRegistroCompra());
            }
        }

        return consultaValidezDocumentosRepository.bandejaConsultaValidez(consultaValidezInDTO);

    }

    private SunatValidarDocumentoResponse consultarDatosSunat(ConsultaValidezOutDTO c){
        SunatValidarDocumentoRequest sunatValidarDocumentoRequest = new SunatValidarDocumentoRequest();
        sunatValidarDocumentoRequest.setCodComp(c.getIdDocumento());
        sunatValidarDocumentoRequest.setFechaEmision(c.getFechaEmision());
        sunatValidarDocumentoRequest.setNumero(Integer.parseInt(c.getNumero()));
        sunatValidarDocumentoRequest.setMonto(c.getTotalPrecioCompra());
        sunatValidarDocumentoRequest.setNumeroSerie(c.getSerie());
        sunatValidarDocumentoRequest.setNumRuc(c.getGlsRuc());
        return sunatService.validarDocumento(sunatValidarDocumentoRequest);
    }
    private void insertarDatosSunat(SunatValidarDocumentoResponse s,String idRegistroCompra){
        consultaValidezDocumentosRepository.insertarDatosSunat(s,idRegistroCompra);
    }

    @Override
    public List<ConsultaValidezOutDTO> bandejaConsultaPointer(ConsultaValidezInDTO consultaValidezInDTO) {
        return consultaValidezDocumentosRepository.bandejaConsultaValidez(consultaValidezInDTO);
    }
}
