/**
 * Autor: Julián Andrés Loaiza Ospina
 * Descripción:
 * Script para generar el paquete que se encarga del proceso masivo
 * Generar las facturas y reportes por ubicación según un archivo plano
 *
 * Ejecutar desde el usuario USER_ALLCOM, localhost, puerto 1521, servicio xepdb1
 * Prerequisito: Haber ejecutado el script data.sql.
 */
 -----------------------------------------------------------------------------

CREATE OR REPLACE PACKAGE LW_PCK_GenerarReporte AS

-- Calcula la tarifa total (suma de las tarifas)
FUNCTION LW_FUNC_CalcularTarifa(p_usuario_nombre VARCHAR2, p_hora DATE, p_tiempo NUMBER, p_mensaje INT)
RETURN NUMBER;
-- Calcula la tarifa por horario
FUNCTION LW_FUNC_CalcularTarifaHorario(p_usuario_nombre VARCHAR2, p_hora DATE)
RETURN NUMBER;
-- Calcula la tarifa por tiempo
FUNCTION LW_FUNC_CalcularTarifaTiempo(p_usuario_nombre VARCHAR2, p_tiempo NUMBER)
RETURN NUMBER;
-- Calcula la tarifa por ubicacion
FUNCTION LW_FUNC_CalcularTarifaUbicacion(p_usuario_nombre VARCHAR2, p_ubicacion VARCHAR2)
RETURN NUMBER;
-- Calcula la tarifa por mensaje
FUNCTION LW_FUNC_CalcularTarifaMensaje(p_usuario_nombre VARCHAR2, p_mensaje INT)
RETURN NUMBER;
-- Calcula verifica si el reporte ya ha sido creado o está en ejecución
FUNCTION LW_FUNC_Verificar(p_reporte_id DATE)
RETURN CHAR;

-- Ejecuta el proceso masivo y crea las facturas y reportes de ubicación
PROCEDURE LW_PROC_GenerarReporte(p_directorio VARCHAR2, p_archivo VARCHAR2, p_tipo VARCHAR2);

END LW_PCK_GenerarReporte;
/


--- Implementación 

CREATE OR REPLACE PACKAGE BODY LW_PCK_GenerarReporte AS
    
    /**
    * Calcula el precio de la tarifa para un usuario dada la hora
    * Verificando dentro de qué rango se encuentra 
    **/

    FUNCTION LW_FUNC_CalcularTarifaHorario(p_usuario_nombre VARCHAR2, p_hora DATE)
    RETURN NUMBER
    AS
        v_monto NUMBER:=0;
    BEGIN

        SELECT precio INTO v_monto
        FROM LW_TARIFAHORARIOS
        WHERE p_usuario_nombre = id_usuario_nombre
            and hora_inicio <= p_hora
            and p_hora < hora_fin;
        
        RETURN v_monto;
    END LW_FUNC_CalcularTarifaHorario;
    

    /**
    * Calcula el precio de la tarifa para un usuario dada el tiempo
    * Verificando dentro de qué rango se encuentra 
    **/


    FUNCTION LW_FUNC_CalcularTarifaTiempo(p_usuario_nombre VARCHAR2, p_tiempo NUMBER)
    RETURN NUMBER
    AS
        v_monto NUMBER:=0;
    BEGIN

        SELECT precio INTO v_monto
        FROM LW_TARIFATIEMPOS   
        WHERE p_usuario_nombre = id_usuario_nombre
            and tiempo_inicio <= p_tiempo
            and p_tiempo < tiempo_fin;
        
        RETURN v_monto;
    END LW_FUNC_CalcularTarifaTiempo;
    

    /**
    * Calcula el precio de la tarifa para un usuario dada la ubicación
    * Verificando dentro de qué rango se encuentra 
    **/
    

    FUNCTION LW_FUNC_CalcularTarifaUbicacion(p_usuario_nombre VARCHAR2, p_ubicacion VARCHAR2)
    RETURN NUMBER
    AS
        v_monto NUMBER:=0;
    BEGIN

        SELECT precio INTO v_monto
        FROM LW_TARIFAUBICACIONES
        WHERE p_usuario_nombre = id_usuario_nombre
            and p_ubicacion = nombre;
        
        RETURN v_monto;
    END LW_FUNC_CalcularTarifaUbicacion;
    

    /**
    * Calcula el precio de la tarifa para un usuario dado el id del mensaje
    * Verificando dentro de qué rango se encuentra el número de caracteres 
    **/

    FUNCTION LW_FUNC_CalcularTarifaMensaje(p_usuario_nombre VARCHAR2, p_mensaje INT)
    RETURN NUMBER
    AS
        v_monto NUMBER:=0;
        v_caracteres INT:=0;
    BEGIN
        
        SELECT num_caracteres INTO v_caracteres
        FROM LW_mensajes
        WHERE p_mensaje = id_mensaje;

        SELECT precio INTO v_monto
        FROM LW_TARIFACARACTERES
        WHERE p_usuario_nombre = id_usuario_nombre
            and caracteres_inicio <= v_caracteres
            and v_caracteres < caracteres_fin;
        
        RETURN v_monto;
    END LW_FUNC_CalcularTarifaMensaje;
    
    /**
    * Calcula el precio de total de la tarifa para un usuario
    * dadas la hora, tiempo y el id del mensaje
    **/


    FUNCTION LW_FUNC_CalcularTarifa(
        p_usuario_nombre VARCHAR2, p_hora DATE, p_tiempo NUMBER, p_mensaje INT)
    RETURN NUMBER
    AS
        v_monto NUMBER:=0;
        v_tarifaHorario NUMBER:=0;
        v_tarifaTiempo NUMBER:=0;
        v_tarifaMensaje NUMBER:=0;
    BEGIN
        v_tarifaHorario :=LW_FUNC_CalcularTarifaHorario(p_usuario_nombre, p_hora);
        v_tarifaTiempo :=LW_FUNC_CalcularTarifaTiempo(p_usuario_nombre, p_tiempo);
        v_tarifaMensaje :=LW_FUNC_CalcularTarifaMensaje(p_usuario_nombre, p_mensaje);
        v_monto := v_tarifaHorario + v_tarifaTiempo  + v_tarifaMensaje;
        
        RETURN v_monto;
    END LW_FUNC_CalcularTarifa;
    


    /**
    * Función que verifica si el reporte se puede generar
    * Si cumple con que: no se ha generado antes y no se está generando.
    **/


    FUNCTION LW_FUNC_Verificar(p_reporte_id DATE)
    RETURN CHAR
    AS
        v_generando CHAR(1) := 'F';
        v_existe CHAR(1) := 'T';
        v_ans CHAR(1) := 'T';
    BEGIN

        BEGIN
            SELECT generando INTO v_generando
            FROM LW_REPORTES
            WHERE p_reporte_id = id_reporte_fecha;
        exception when NO_DATA_FOUND THEN
            v_existe := 'F';
        END;

        IF (v_generando = 'T' or v_existe = 'T') THEN
            v_ans := 'F';
        END IF;

        RETURN v_ans;
    END LW_FUNC_Verificar;

    /**
    * Procedimiento que se encarga de generar las facturas a los clientes
    * y los reportes por ubicación leyendo el archivo de texto plano
    **/
    

    PROCEDURE LW_PROC_GenerarReporte
    (p_directorio VARCHAR2, p_archivo VARCHAR2, p_tipo VARCHAR2)
    AS
        CURSOR c_usuarios is 
        SELECT id_usuario_nombre FROM LW_USUARIOS
        WHERE id_rol_nombre = 'CLIENTE';
        
        CURSOR c_ubicaciones is 
        SELECT ubicacion_nombre FROM LW_UBICACIONNOMBRES; 

        TYPE kv_factura IS TABLE of NUMBER INDEX BY VARCHAR2(40); 
        v_mapfactura kv_factura; -- Tabla temporal indice valor
        i_factura VARCHAR2(40);

        TYPE kv_ubicacion IS TABLE of NUMBER INDEX BY VARCHAR2(40); 
        v_mapubicacion kv_ubicacion; -- Tabla temporal indice valor
        i_ubicacion VARCHAR2(40);

        v_archivo UTL_FILE.FILE_TYPE; -- Archivo plano
        v_linea VARCHAR2(210); -- Cada línea del archivo
        v_cliente VARCHAR2(40);
        v_hora VARCHAR2(40);
        v_tiempo VARCHAR2(40);
        v_ubicacion VARCHAR2(40);
        v_mensaje VARCHAR2(40);
        v_id_reporte DATE; -- Fecha del reporte
    
        v_montoclic NUMBER := 0; -- Monto para Facturas clientes
        v_montoubicacion NUMBER := 0; -- Monto para Reporte por ubicación
    
        v_ejecutar CHAR(1) := 'T';

    BEGIN
        v_archivo := UTL_FILE.FOPEN (p_directorio, p_archivo, 'r');
        
        BEGIN
            UTL_FILE.GET_LINE (v_archivo, v_linea); -- Leo la primera línea
        EXCEPTION
        WHEN NO_DATA_FOUND THEN
            v_ejecutar := 'F';
        END;
        
        -- Verifico si debo ejecutar o no el proceso
        IF ( (v_ejecutar = 'T') and (LW_FUNC_Verificar(v_linea)) = 'T') THEN
            
            v_id_reporte := to_date(v_linea, 'DD/MON/YYYY');
            INSERT INTO LW_REPORTES VALUES(v_id_reporte, 'T', p_tipo, sysdate);
            COMMIT;
            
            -- Inicializo facturas en 0
            FOR n IN c_usuarios LOOP 
                v_mapfactura(n.id_usuario_nombre) := 0; 
            END LOOP;

            -- Inicializo reporte ubicación en 0
            FOR n IN c_ubicaciones LOOP 
                v_mapubicacion(n.ubicacion_nombre) := 0; 
            END LOOP;
            
            
            LOOP
                BEGIN
                    UTL_FILE.GET_LINE ( v_archivo, v_linea);
                exception
                    when NO_DATA_FOUND THEN
                        exit;
                    END;
                    
                    -- Extraigo del archivo con los pipes
                    v_cliente := regexp_substr(v_linea, '[^|]+', 1, 1);
                    v_hora := regexp_substr(v_linea, '[^|]+', 1, 2);
                    v_tiempo := regexp_substr(v_linea, '[^|]+', 1, 3);
                    v_ubicacion := regexp_substr(v_linea, '[^|]+', 1, 4);
                    v_mensaje := regexp_substr(v_linea, '[^|]+', 1, 5);

                    -- Calculo la tarifa total sin la ubicacion
                    v_montoclic := LW_FUNC_calculartarifa(v_cliente, 
                        to_DATE(v_hora, 'HH24/MI'), to_NUMBER(v_tiempo), to_NUMBER(v_mensaje));
                    -- Calculo la tarifa de la ubicacion
                    v_montoubicacion := LW_FUNC_calculartarifaubicacion(v_cliente, v_ubicacion);
                    
                    -- sumo al total de la factura + la ubicacion
                    v_mapfactura(v_cliente) := v_mapfactura(v_cliente) + v_montoclic + v_montoubicacion;
                    -- sumo al total del reporte de la ubicacion
                    v_mapubicacion(v_ubicacion) := v_mapubicacion(v_ubicacion) + v_montoubicacion;

            END LOOP;
            
            -- Inserto facturas en las tablas
            i_factura := v_mapfactura.FIRST;
            WHILE i_factura IS NOT NULL LOOP
                INSERT INTO LW_FACTURAS VALUES(default, i_factura, v_id_reporte, v_mapfactura(i_factura));
                i_factura := v_mapfactura.NEXT(i_factura);
            END LOOP;
        
            -- Inserto reportes en las tablas
            i_ubicacion := v_mapubicacion.FIRST;
            WHILE i_ubicacion IS NOT NULL LOOP
                INSERT INTO LW_UBICACIONES VALUES(default, i_ubicacion, v_id_reporte, v_mapubicacion(i_ubicacion));
                i_ubicacion := v_mapubicacion.NEXT(i_ubicacion);
            END LOOP;
            
            UPDATE LW_REPORTES SET generando = 'F' WHERE id_reporte_fecha = v_id_reporte;
            COMMIT;

        END IF;
        UTL_FILE.FCLOSE ( v_archivo);
    END LW_PROC_GenerarReporte;

END LW_PCK_GenerarReporte;
