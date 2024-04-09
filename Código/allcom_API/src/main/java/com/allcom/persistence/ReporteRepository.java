package com.allcom.persistence;

import com.allcom.domain.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.Map;

// Procedimiento que utiliza JDBC para llamar al procedimiento masivo
@Repository
public class ReporteRepository implements ReportRepository {

    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean generateReport() {

        try {
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("lw_pck_generarreporte")
                    .withProcedureName("lw_proc_generarreporte");

            Map<String, Object> out = simpleJdbcCall.execute(
                    new MapSqlParameterSource("p_directorio", "DIR_TEMP")
                    .addValue("p_archivo", "reporte.txt")
                    .addValue("p_tipo", "Manual"));
            return true;
        }catch (Exception e) {
            System.out.println("Error al generar facturas");
            return false;
        }
    }
}
