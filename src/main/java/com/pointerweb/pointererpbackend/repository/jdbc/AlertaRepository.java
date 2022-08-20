package com.pointerweb.pointererpbackend.repository.jdbc;

import com.pointerweb.pointererpbackend.model.dto.AlertasInDTO;
import com.pointerweb.pointererpbackend.model.dto.AlertasOutDTO;
import com.pointerweb.pointererpbackend.model.dto.BandejaRequisicionDTO;
import com.pointerweb.pointererpbackend.model.dto.BandejaRequisicionInDTO;
import com.pointerweb.pointererpbackend.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class AlertaRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;



    public List<AlertasOutDTO> listAlertas(AlertasInDTO params){

        String empresa = params.getIdEmpresa()!=null?params.getIdEmpresa():"";
        String usuario = params.getIdUsuario()!=null?params.getIdUsuario():"";

        String sql = "call spu_SelAlertas('"+empresa+"','"+usuario+"');";
        return jdbcTemplate.query(sql,new AlertasMapper());

    }


    private static final class AlertasMapper implements RowMapper<AlertasOutDTO> {

        @Override
        public AlertasOutDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

            AlertasOutDTO t = new AlertasOutDTO();
            t.setIdAlerta(rs.getString("idAlerta"));
            t.setGlsMensaje(rs.getString("GlsMensaje"));
            return t;

        }
    }

}
