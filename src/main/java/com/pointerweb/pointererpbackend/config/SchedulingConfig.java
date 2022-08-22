package com.pointerweb.pointererpbackend.config;

import com.pointerweb.pointererpbackend.model.dto.ConsultaValidezInDTO;
import com.pointerweb.pointererpbackend.service.ConsultaValidezDocumentoService;
import com.pointerweb.pointererpbackend.service.SunatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingConfig {

    @Autowired
    ConsultaValidezDocumentoService consultaValidezDocumentoService;

    /*
    @Scheduled(cron = "${cron.expression}")
    public void scheduleFixedDelayTask() {
        ConsultaValidezInDTO consultaValidezInDTO = new ConsultaValidezInDTO();
        consultaValidezInDTO.setFechaDesde("2022-01-01");
        consultaValidezInDTO.setFechaHasta("2022-12-31");
        consultaValidezDocumentoService.bandejaConsultaSunat(consultaValidezInDTO);
    }

     */

}
