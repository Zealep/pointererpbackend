package com.pointerweb.pointererpbackend.repository.jdbc;

import com.pointerweb.pointererpbackend.model.dto.BandejaRequisicionDTO;
import com.pointerweb.pointererpbackend.model.dto.ConsultaValidezInDTO;
import com.pointerweb.pointererpbackend.model.dto.ConsultaValidezOutDTO;
import com.pointerweb.pointererpbackend.model.dto.sunat.SunatValidarDocumentoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
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
            t.setNumero(rs.getString("NroComprobante"));
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
            return t;

        }
    }

    public void insertarDatosSunat(SunatValidarDocumentoResponse s,String idRegistroCompra){
        Map<String, Object> params = new HashMap<>();
        params.put("var1",s.getData().getEstadoCp());
        params.put("var2",s.getData().getEstadoRuc());
        params.put("var3",s.getData().getCondDomiRuc());
        params.put("var4",idRegistroCompra);
        jdbcTemplate.update(
                "INSERT INTO registrocompras (idSunatEstadoDocumento, idSunatEstadoProveedor,idSunatEstadoDomicilioProveedor) VALUES (:var1, :var2,:var3) WHERE idRegistroCompra = :var4",
                params
        );
    }
}
