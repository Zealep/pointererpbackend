package com.pointerweb.pointererpbackend.service;

import com.pointerweb.pointererpbackend.model.dto.ConsultaValidezInDTO;
import com.pointerweb.pointererpbackend.model.dto.ConsultaValidezOutDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ConsultaValidezDocumentoService {

    List<ConsultaValidezOutDTO> bandejaConsultaSunat(ConsultaValidezInDTO consultaValidezInDTO);

    List<ConsultaValidezOutDTO> bandejaConsultaPointer(ConsultaValidezInDTO consultaValidezInDTO);
}
