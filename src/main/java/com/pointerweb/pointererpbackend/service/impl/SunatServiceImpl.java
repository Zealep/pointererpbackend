package com.pointerweb.pointererpbackend.service.impl;

import com.pointerweb.pointererpbackend.model.dto.sunat.SunatTokenResponse;
import com.pointerweb.pointererpbackend.model.dto.sunat.SunatValidarDocumentoRequest;
import com.pointerweb.pointererpbackend.model.dto.sunat.SunatValidarDocumentoResponse;
import com.pointerweb.pointererpbackend.service.SunatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service("sunatService")
public class SunatServiceImpl implements SunatService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.sunat.grant.type}")
    private String grantType;

    @Value("${api.sunat.grant.scope}")
    private String scope;

    @Value("${client.sunat.id}")
    private String clientId;

    @Value("${client.sunat.secret}")
    private String clientSecret;

    @Value("${api.sunat.login}")
    private String urlApi;

    @Override
    public SunatTokenResponse token() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("grant_type", grantType);
        map.add("scope", scope);
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<SunatTokenResponse> response = restTemplate.postForEntity( urlApi+"/"+clientId+"/oauth2/token/", request , SunatTokenResponse.class );
        return response.getBody();
    }

    @Override
    public SunatValidarDocumentoResponse validarDocumento(SunatValidarDocumentoRequest sunatValidarDocumentoRequest) {
        SunatTokenResponse token = this.token();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(token.getAccess_token());
        HttpEntity<SunatValidarDocumentoRequest> entity = new HttpEntity<>(sunatValidarDocumentoRequest, headers);
        ResponseEntity<SunatValidarDocumentoResponse> response = restTemplate.exchange(scope+"/"+sunatValidarDocumentoRequest.getNumRuc()+"/validarcomprobante", HttpMethod.POST, entity, SunatValidarDocumentoResponse.class);
        return response.getBody();

    }
}
