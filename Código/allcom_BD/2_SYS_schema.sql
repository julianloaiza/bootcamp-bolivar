/**
 * Autor: Julián Andrés Loaiza Ospina
 * Descripción:
 * Script para generar las tablas del proyecto
 * Ejecutar desde el usuario SYS, localhost, puerto 1521, servicio xepdb1
 * Prerequisito: Haber ejecutado el script user.sql.
 */
 -----------------------------------------------------------------------------


CREATE TABLE USER_ALLCOM.LW_REPORTES (
    id_reporte_fecha DATE NOT NULL,
    generando CHAR(1) NOT NULL,
    tipo VARCHAR2(10) NOT NULL,
    fecha_generacion DATE NOT NULL
);
ALTER TABLE USER_ALLCOM.LW_REPORTES ADD CONSTRAINT pk_reportes PRIMARY KEY (id_reporte_fecha);



CREATE TABLE USER_ALLCOM.LW_UBICACIONNOMBRES (
    ubicacion_nombre VARCHAR2(40));
ALTER TABLE USER_ALLCOM.LW_UBICACIONNOMBRES ADD CONSTRAINT pk_ubicacionnombres PRIMARY KEY (ubicacion_nombre);



CREATE TABLE USER_ALLCOM.LW_UBICACIONES (
    id_ubicacion INT GENERATED ALWAYS AS IDENTITY,
    ubicacion_nombre VARCHAR2(40),
    id_reporte_fecha DATE NOT NULL,
    facturado NUMBER NOT NULL
);
ALTER TABLE USER_ALLCOM.LW_UBICACIONES ADD CONSTRAINT pk_ubicaciones PRIMARY KEY (id_ubicacion);
ALTER TABLE USER_ALLCOM.LW_UBICACIONES ADD CONSTRAINT fk_ubicaciones_ubicacionnombres FOREIGN KEY (ubicacion_nombre)
REFERENCES USER_ALLCOM.LW_UBICACIONNOMBRES (ubicacion_nombre);
ALTER TABLE USER_ALLCOM.LW_UBICACIONES ADD CONSTRAINT fk_ubicaciones_reportes FOREIGN KEY (id_reporte_fecha)
REFERENCES USER_ALLCOM.LW_REPORTES (id_reporte_fecha);



CREATE TABLE USER_ALLCOM.LW_ROLES (
    id_rol_nombre VARCHAR2(10)
);
ALTER TABLE USER_ALLCOM.LW_ROLES ADD CONSTRAINT pk_roles PRIMARY KEY (id_rol_nombre);



CREATE TABLE USER_ALLCOM.LW_USUARIOS (
    id_usuario_nombre VARCHAR2(40),
    id_rol_nombre VARCHAR2(10),
    contrasenia VARCHAR2(40) NOT NULL
);
ALTER TABLE USER_ALLCOM.LW_USUARIOS ADD CONSTRAINT pk_usuarios PRIMARY KEY (id_usuario_nombre);
ALTER TABLE USER_ALLCOM.LW_USUARIOS ADD CONSTRAINT fk_usuarios_roles FOREIGN KEY (id_rol_nombre)
REFERENCES USER_ALLCOM.LW_ROLES (id_rol_nombre);



CREATE TABLE USER_ALLCOM.LW_FACTURAS (
    id_factura INT GENERATED ALWAYS AS IDENTITY,
    id_usuario_nombre VARCHAR2(40) NOT NULL,
    id_reporte_fecha DATE NOT NULL,
    monto NUMBER NOT NULL
);
ALTER TABLE USER_ALLCOM.LW_FACTURAS ADD CONSTRAINT pk_facturas PRIMARY KEY (id_factura);
ALTER TABLE USER_ALLCOM.LW_FACTURAS ADD CONSTRAINT fk_facturas_usuarios FOREIGN KEY (id_usuario_nombre)
REFERENCES USER_ALLCOM.LW_USUARIOS (id_usuario_nombre);
ALTER TABLE USER_ALLCOM.LW_FACTURAS ADD CONSTRAINT fk_facturas_reportes FOREIGN KEY (id_reporte_fecha)
REFERENCES USER_ALLCOM.LW_REPORTES (id_reporte_fecha);



CREATE TABLE USER_ALLCOM.LW_SOLICITUDES (
    id_solicitud INT GENERATED ALWAYS AS IDENTITY,
    id_usuario_nombre VARCHAR2(40) NOT NULL,
    id_factura INT NOT NULL,
    estado CHAR(1) NOT NULL,
    descripcion VARCHAR2(200)
);
ALTER TABLE USER_ALLCOM.LW_SOLICITUDES ADD CONSTRAINT pk_solicitudes PRIMARY KEY (id_solicitud);
ALTER TABLE USER_ALLCOM.LW_SOLICITUDES ADD CONSTRAINT fk_solicitudes_usuarios FOREIGN KEY (id_usuario_nombre)
REFERENCES USER_ALLCOM.LW_USUARIOS (id_usuario_nombre);
ALTER TABLE USER_ALLCOM.LW_SOLICITUDES ADD CONSTRAINT fk_solicitudes_facturas FOREIGN KEY (id_factura)
REFERENCES USER_ALLCOM.LW_FACTURAS (id_factura);




CREATE TABLE USER_ALLCOM.LW_MENSAJES (
    id_mensaje  INT GENERATED ALWAYS AS IDENTITY,
    id_usuario_nombre VARCHAR2(40) NOT NULL,
    num_caracteres INT NOT NULL
);
ALTER TABLE USER_ALLCOM.LW_MENSAJES ADD CONSTRAINT pk_mensajes PRIMARY KEY (id_mensaje);
ALTER TABLE USER_ALLCOM.LW_MENSAJES ADD CONSTRAINT fk_mensajes_usuarios FOREIGN KEY (id_usuario_nombre)
REFERENCES USER_ALLCOM.LW_USUARIOS (id_usuario_nombre);




CREATE TABLE USER_ALLCOM.LW_TARIFAHORARIOS (
    id_tarifahorario  INT GENERATED ALWAYS AS IDENTITY,
    id_usuario_nombre VARCHAR2(40) NOT NULL,
    hora_inicio DATE NOT NULL,
    hora_fin DATE NOT NULL,
    precio NUMBER NOT NULL
);
ALTER TABLE USER_ALLCOM.LW_TARIFAHORARIOS ADD CONSTRAINT pk_tarifahorarios PRIMARY KEY (id_tarifahorario);
ALTER TABLE USER_ALLCOM.LW_TARIFAHORARIOS ADD CONSTRAINT fk_tarifahorarios_usuarios FOREIGN KEY (id_usuario_nombre)
REFERENCES USER_ALLCOM.LW_USUARIOS (id_usuario_nombre);




CREATE TABLE USER_ALLCOM.LW_TARIFACARACTERES (
    id_tarifacaracter  INT GENERATED ALWAYS AS IDENTITY,
    id_usuario_nombre VARCHAR2(40) NOT NULL,
    caracteres_inicio INT NOT NULL,
    caracteres_fin INT NOT NULL,
    precio NUMBER NOT NULL
);
ALTER TABLE USER_ALLCOM.LW_TARIFACARACTERES ADD CONSTRAINT pk_tarifacaracteres PRIMARY KEY (id_tarifacaracter);
ALTER TABLE USER_ALLCOM.LW_TARIFACARACTERES ADD CONSTRAINT fk_tarifacaracteres_usuarios FOREIGN KEY (id_usuario_nombre)
REFERENCES USER_ALLCOM.LW_USUARIOS (id_usuario_nombre);




CREATE TABLE USER_ALLCOM.LW_TARIFATIEMPOS (
    id_tarifatiempo  INT GENERATED ALWAYS AS IDENTITY,
    id_usuario_nombre VARCHAR2(40) NOT NULL,
    tiempo_inicio NUMBER NOT NULL,
    tiempo_fin NUMBER NOT NULL,
    precio NUMBER NOT NULL
);
ALTER TABLE USER_ALLCOM.LW_TARIFATIEMPOS ADD CONSTRAINT pk_tarifatiempos PRIMARY KEY (id_tarifatiempo);
ALTER TABLE USER_ALLCOM.LW_TARIFATIEMPOS ADD CONSTRAINT fk_tarifatiempos_usuarios FOREIGN KEY (id_usuario_nombre)
REFERENCES USER_ALLCOM.LW_USUARIOS (id_usuario_nombre);




CREATE TABLE USER_ALLCOM.LW_TARIFAUBICACIONES (
    id_tarifaubicacion INT GENERATED ALWAYS AS IDENTITY,
    id_usuario_nombre VARCHAR2(40) NOT NULL,
    nombre VARCHAR2(40) NOT NULL,
    precio NUMBER NOT NULL
);
ALTER TABLE USER_ALLCOM.LW_TARIFAUBICACIONES ADD CONSTRAINT pk_tarifaubicaciones PRIMARY KEY (id_tarifaubicacion);
ALTER TABLE USER_ALLCOM.LW_TARIFAUBICACIONES ADD CONSTRAINT fk_tarifaubicaciones_ubicacionnombres FOREIGN KEY (nombre)
REFERENCES USER_ALLCOM.LW_UBICACIONNOMBRES (ubicacion_nombre);
ALTER TABLE USER_ALLCOM.LW_TARIFAUBICACIONES ADD CONSTRAINT fk_tarifaubicaciones_usuarios FOREIGN KEY (id_usuario_nombre)
REFERENCES USER_ALLCOM.LW_USUARIOS (id_usuario_nombre);



-- En caso de ya tener las tablas borrarlas:

/*
drop table USER_ALLCOM.LW_TARIFAUBICACIONES;
drop table USER_ALLCOM.LW_TARIFATIEMPOS;
drop table USER_ALLCOM.LW_TARIFACARACTERES;
drop table USER_ALLCOM.LW_TARIFAHORARIOS;
drop table USER_ALLCOM.LW_MENSAJES;
drop table USER_ALLCOM.LW_SOLICITUDES;
drop table USER_ALLCOM.LW_FACTURAS;
drop table USER_ALLCOM.LW_USUARIOS;
drop table USER_ALLCOM.LW_ROLES;    
drop table USER_ALLCOM.LW_UBICACIONES;
drop table USER_ALLCOM.LW_UBICACIONNOMBRES;
drop table USER_ALLCOM.LW_REPORTES;
*/
