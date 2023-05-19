package com.pointerweb.pointererpbackend.repository.jdbc;


import com.pointerweb.pointererpbackend.model.dto.BandejaReqMaterialInDTO;
import com.pointerweb.pointererpbackend.model.dto.BandejaReqMaterialOutDTO;
import com.pointerweb.pointererpbackend.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RequerimientoMaterialRepository {


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<BandejaReqMaterialOutDTO> bandejaReqMaterial(BandejaReqMaterialInDTO bandejaReqMaterialInDTO){


        String fechaDesde = bandejaReqMaterialInDTO.getFechaDesde()!=null? Utils.convertDateToStringFormatyyyyMMdd(bandejaReqMaterialInDTO.getFechaDesde()):"";
        String fechaHasta = bandejaReqMaterialInDTO.getFechaHasta()!=null?Utils.convertDateToStringFormatyyyyMMdd(bandejaReqMaterialInDTO.getFechaHasta()):"";
        String codigo = bandejaReqMaterialInDTO.getCodigo()!=null?bandejaReqMaterialInDTO.getCodigo():"";
        String prioridad = bandejaReqMaterialInDTO.getPrioridad()!=null?bandejaReqMaterialInDTO.getPrioridad():"";
        String estado = formatCheckBoxEstado(bandejaReqMaterialInDTO.getEstado()).toString();


        String  sql = "call spu_SelReqMateriales('01','19010001','20030014' ,'"+fechaDesde+"','"+fechaHasta+"','"+codigo+"' ,'"+prioridad+"','"+estado+"','C');";


        try {
            return jdbcTemplate.query(sql,new BandejaReqMaterialMapper());
        } catch (Exception e){
            return null;
        }
    }


    private static final class BandejaReqMaterialMapper implements RowMapper<BandejaReqMaterialOutDTO> {

        @Override
        public BandejaReqMaterialOutDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

            BandejaReqMaterialOutDTO t = new BandejaReqMaterialOutDTO();
            t.setCodigo(rs.getString("idReqMateriales"));
            t.setFechaEmision(rs.getDate("FechaEmision"));
            t.setSolicitante(rs.getString("GlsPersona"));
            t.setMoneda(rs.getString("idMoneda"));
            t.setEstado(rs.getString("estReqMateriales"));
            t.setCampanha(rs.getString("GlsCampana"));
            t.setOperacion(rs.getString("idOrdenProduccion"));
            t.setObservacion(rs.getString("obsReqMateriales"));
            t.setTotal(rs.getBigDecimal("TotalPVNeto"));
            t.setTipo(rs.getString("GlsTipo"));
            t.setPrioridad(rs.getString("GlsPrioridad"));
            return t;
        }
    }

    private String formatCheckBoxEstado(String estados){

        if(estados==null || estados.equals("")){
            return "";
        }

            String[] arrayEstados = estados.split(",");
            StringBuilder sb = new StringBuilder();
            sb.append("<a>");

            Map<String,String> mapEstados = new HashMap<>();
            mapEstados.put("GEN","<chGenerado>0</chGenerado>");
            mapEstados.put("PAP","<chPreAprobado>0</chPreAprobado>");
            mapEstados.put("APR","<chAprobado>0</chAprobado>");
            mapEstados.put("ANU","<chAnulado>0</chAnulado>");
            mapEstados.put("REC","<chRechazado>0</chRechazado>");
            mapEstados.put("ATN","<chAtendido>0</chAtendido>");

            for(String e:arrayEstados){
                if(mapEstados.containsKey(e)){
                    String valor = mapEstados.get(e);
                    mapEstados.put(e,valor.replace('0','1'));
                }
            }
            for (String valor : mapEstados.values()) {
                sb.append(valor);
            }
            sb.append("<modo>normal</modo></a>");
            return sb.toString();
    }
}
