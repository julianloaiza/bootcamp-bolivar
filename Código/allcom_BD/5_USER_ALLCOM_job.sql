
/**
 * Autor: Julián Andrés Loaiza Ospina
 * Descripción:
 * Script para generar el JOB que se encarga de ejecutar el proceso masivo
 * Generar las facturas y reportes por ubicación según un archivo plano
 * Esto lo hará de forma mensual el 1ro de cada mes.
 *
 * Ejecutar desde el usuario USER_ALLCOM, localhost, puerto 1521, servicio xepdb1
 * Prerequisito: Haber ejecutado el script package.sql.
 */
 -----------------------------------------------------------------------------


--Antes de crear el JOB Asegúrese de que exista un archivo que:
/*

Corresponda a un reporte que NO se haya generado con anterioridad (Fecha única)
Esté en la Ubicación: "C:\temp"
Tenga como nombre: "Reporte.txt"
Su contenido este en el formato correcto:
Fecha
Cliente|Hora|Tiempo|Ubicacion|Mensaje
Cliente|Hora|Tiempo|Ubicacion|Mensaje
...

Para el ejemplo colocar el archivo:
reporte.txt en la ruta "C:\temp"

*/

BEGIN
  DBMS_SCHEDULER.create_job (
    job_name        => 'generar_reporte_mensual',
    job_type        => 'PLSQL_BLOCK',
    job_action      => '
                        DECLARE
                            v_directorio varchar2(10) := ''DIR_TEMP'';
                            v_archivo varchar2(10) := ''reporte.txt'';
                            v_tipo varchar2(10) := ''Auto'';
                        BEGIN
                            lw_pck_generarreporte.lw_proc_generarreporte(v_directorio,v_archivo,v_tipo);
                        END;',
    start_date      => SYSTIMESTAMP,
    repeat_interval => 'freq=MONTHLY; BYMONTHDAY=1; byhour=0; byminute=0; bysecond=0;',
    end_date        => NULL,
    enabled         => TRUE,
    comments        => 'Job para generar reporte de manera mensual.');
END;

-- Para eliminar el JOB
/*
BEGIN
  dbms_scheduler.drop_job(job_name => 'generar_reporte_mensual');
END;
*/