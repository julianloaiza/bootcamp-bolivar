/**
 * Autor: Julián Andrés Loaiza Ospina
 * Descripción:
 * Script para crear Tablespace, Datafile y usuario asociado
 * Ejecutar desde el usuario SYS, localhost, puerto 1521, servicio xepdb1
 */
 -----------------------------------------------------------------------------


-- Creación del tablespace ts_allcom

CREATE TABLESPACE ts_allcom DATAFILE 'DF_ALLCOM.dat' SIZE 100M AUTOEXTEND ON NEXT 100M;

-- Creación del usuario y asignación del tablespace
-- Usuario: user_allcom
-- Contraseña: 1234

CREATE USER user_allcom IDENTIFIED BY 1234 DEFAULT TABLESPACE ts_allcom QUOTA UNLIMITED ON ts_allcom;

-- Permisos para el usuario

GRANT CREATE SESSION TO user_allcom;
GRANT CREATE PROCEDURE TO user_allcom;

-- En caso de no tener el directorio creado, crearlo.
/*
CREATE DIRECTORY dir_temp AS 'C:\temp';
*/

GRANT READ,WRITE ON DIRECTORY dir_temp TO user_allcom;
GRANT EXECUTE ON SYS.UTL_FILE TO user_allcom;
GRANT CREATE JOB TO user_allcom;

 -- En caso de tener el usuario y el tablespace ya creado eliminarlo:
/*
drop user user_allcom cascade;

drop tablespace ts_allcom
    including contents and datafiles;
*/