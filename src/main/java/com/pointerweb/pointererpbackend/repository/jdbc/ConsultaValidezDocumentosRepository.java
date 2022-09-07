package com.pointerweb.pointererpbackend.repository.jdbc;

import com.pointerweb.pointererpbackend.model.dto.BandejaRequisicionDTO;
import com.pointerweb.pointererpbackend.model.dto.ConsultaValidezInDTO;
import com.pointerweb.pointererpbackend.model.dto.ConsultaValidezOutDTO;
import com.pointerweb.pointererpbackend.model.dto.sunat.SunatValidarDocumentoResponse;
import com.pointerweb.pointererpbackend.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ConsultaValidezDocumentosRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public List<ConsultaValidezOutDTO> bandejaConsultaValidez(ConsultaValidezInDTO consultaValidezInDTO){


        //final String sql2 = "call spu_Web_ListaRegComprasValidacion('01','','','2020-01-01','2022-12-01','','','','','S');";

        String fechaDesde = consultaValidezInDTO.getFechaDesde()!=null?consultaValidezInDTO.getFechaDesde():"";
        String fechaHasta = consultaValidezInDTO.getFechaHasta()!=null?consultaValidezInDTO.getFechaHasta():"";
        String documento = consultaValidezInDTO.getDocumento()!=null?consultaValidezInDTO.getDocumento():"";
        String proveedor = consultaValidezInDTO.getProveedor()!=null?consultaValidezInDTO.getProveedor():"";
        String moneda = consultaValidezInDTO.getMoneda()!=null?consultaValidezInDTO.getMoneda():"";
        String ordenCompra = consultaValidezInDTO.getOrdenCompra()!=null?consultaValidezInDTO.getOrdenCompra():"";


        String  sql = "call spu_Web_ListaRegComprasValidacion('01','','','"+fechaDesde+"','"+fechaHasta+"','"+documento+"','"+proveedor+"','"+moneda+"','"+ordenCompra+"','S');";


        /*
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("fechaDesde",consultaValidezInDTO.getFechaDesde());
        namedParameters.addValue("fechaHasta",consultaValidezInDTO.getFechaHasta());
        namedParameters.addValue("documento",consultaValidezInDTO.getDocumento());
        namedParameters.addValue("proveedor",consultaValidezInDTO.getProveedor());
        namedParameters.addValue("moneda",consultaValidezInDTO.getMoneda());
        namedParameters.addValue("ordenCompra",consultaValidezInDTO.getOrdenCompra());

         */
        try {
            return jdbcTemplate.query(sql,new ConsultaValidezMapper());
        } catch (Exception e){
        return null;
        }
    }


    private static final class ConsultaValidezMapper implements RowMapper<ConsultaValidezOutDTO> {

        @Override
        public ConsultaValidezOutDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

            ConsultaValidezOutDTO t = new ConsultaValidezOutDTO();
            t.setNroAuxiliar(rs.getString("idNroAuxiliar"));
            t.setTipoDocumento(rs.getString("GlsTipoDoc"));
            t.setSerie(rs.getString("idSerie"));
            t.setNumero(rs.getString("NroComprobante")!=""? Utils.quitarCeros(rs.getString("NroComprobante")):rs.getString("NroComprobante"));
            t.setNroDocumentoProveedor(rs.getString("RUCProveedor"));
            t.setRazonSocialProveedor(rs.getString("GlsProveedor"));
            t.setFechaEmision(rs.getString("FecEmision"));
            t.setFechaContable(rs.getString("FechaComproRef"));
            t.setMoneda(rs.getString("GlsMoneda"));
            t.setBase(rs.getBigDecimal("TotalBaseImponible"));
            t.setExonerado(rs.getBigDecimal("TotalExonerado"));
            t.setIgv(rs.getBigDecimal("TotalIGVCompra"));
            t.setTotal(rs.getBigDecimal("TotalValorCompra"));
            t.setEstado(rs.getString("estRegistroCompra"));
            t.setIdDocumento(rs.getString("idDocumento"));
            t.setTotalPrecioCompra(rs.getBigDecimal("TotalPrecioCompra"));
            t.setGlsRuc(rs.getString("glsRuc"));
            t.setIdRegistroCompra(rs.getString("idRegistroCompra"));
            t.setIdSunatEstadoDocumento(rs.getString("idSunatEstadoDocumento"));
            t.setGlsSunatEstadoDocumento(rs.getString("glsSunatEstadoDocumento"));
            t.setIdSunatEstadoProveedor(rs.getString("idSunatEstadoProveedor"));
            t.setGlsSunatEstadoProveedor(rs.getString("glsSunatEstadoProveedor"));
            t.setIdSunatEstadoDomicilioProveedor(rs.getString("idSunatEstadoDomicilioProveedor"));
            t.setGlsSunatEstadoDomicilioProveedor(rs.getString("glsSunatEstadoDomicilioProveedor"));
            t.setGlsSunatObservacionesDocumento(rs.getString("glsSunatObservacionesDocumento"));
            t.setAbreDocumento(rs.getString("AbreDocumento"));
            return t;

        }
    }

    public void insertarDatosSunat(SunatValidarDocumentoResponse s,String idRegistroCompra){
       String obs ="";
        Map<String, Object> params = new HashMap<>();
       if(s.isSuccess()){
           if(s.getData()!=null && s.getData().getObservaciones()!=null){
               obs = Arrays.toString(s.getData().getObservaciones().toArray());
           }

           params.put("var1",s.getData().getEstadoCp());
           params.put("var2",s.getData().getEstadoRuc());
           params.put("var3",s.getData().getCondDomiRuc());
           params.put("var4", obs);
           params.put("var5",idRegistroCompra);
           jdbcTemplate.update(
                   "UPDATE registrocompras set idSunatEstadoDocumento=:var1, idSunatEstadoProveedor = :var2 , idSunatEstadoDomicilioProveedor = :var3 , glsSunatObservacionesDocumento= :var4 WHERE idRegistroCompra = :var5 ;",
                   params
           );
       }
       else{
           params.put("var1",s.getMessage());
           params.put("var2",idRegistroCompra);
           jdbcTemplate.update(
                   "UPDATE registrocompras set glsSunatObservacionesDocumento= :var1 WHERE idRegistroCompra = :var2 ;",
                   params
           );

       }





    }
}
