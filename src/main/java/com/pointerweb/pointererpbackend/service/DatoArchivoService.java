package com.pointerweb.pointererpbackend.service;

import com.pointerweb.pointererpbackend.model.DatoArchivo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DatoArchivoService {

    DatoArchivo findById(String id);
    List<DatoArchivo> findByIdCodigoRelacionalAndIdProceso(String id,String idProceso);
    List<DatoArchivo> findAll();
    DatoArchivo save(DatoArchivo d, MultipartFile file,String codigoRelacional);
    DatoArchivo saveList(DatoArchivo[] d, MultipartFile[] files,String codigoRelacional);
    void deleteById(String id);
    void deleteFile(String path);
    void deleteFilesByEntityAndProcess(String id,String proceso);
    byte[] getFile(String identificador);
    String getFileBase64(String url);
}
