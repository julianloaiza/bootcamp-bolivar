/**
 * Autor: Julián Andrés Loaiza Ospina
 * Descripción:
 * Script para insertar información a las tablas del proyecto
 * Ejecutar desde el usuario USER_ALLCOM, localhost, puerto 1521, servicio xepdb1
 * Prerequisito: Haber ejecutado el script schema.sql desde SYS.
 */
 -----------------------------------------------------------------------------

INSERT INTO LW_REPORTES VALUES (to_date('1/Enero/2022', 'DD/MON/YYYY'), 'F', 'Manual', sysdate);
INSERT INTO LW_REPORTES VALUES (to_date('1/Febrero/2022', 'DD/MON/YYYY'), 'F', 'Manual', sysdate);

INSERT INTO LW_UBICACIONNOMBRES VALUES ('Bogotá');
INSERT INTO LW_UBICACIONNOMBRES VALUES ('Cali');
INSERT INTO LW_UBICACIONNOMBRES VALUES ('Medellín');
INSERT INTO LW_UBICACIONNOMBRES VALUES ('Barranquilla');


INSERT INTO LW_UBICACIONES VALUES (default, 'Bogotá', to_date('1/Enero/2022', 'DD/MON/YYYY'), 12000);
INSERT INTO LW_UBICACIONES VALUES (default, 'Cali', to_date('1/Enero/2022', 'DD/MON/YYYY'), 11000);
INSERT INTO LW_UBICACIONES VALUES (default, 'Medellín', to_date('1/Enero/2022', 'DD/MON/YYYY'), 12500);
INSERT INTO LW_UBICACIONES VALUES (default, 'Cali',to_date('1/Febrero/2022', 'DD/MON/YYYY'), 10000);
INSERT INTO LW_UBICACIONES VALUES (default, 'Bogotá',to_date('1/Febrero/2022', 'DD/MON/YYYY'), 13000);
INSERT INTO LW_UBICACIONES VALUES (default, 'Medellín',to_date('1/Febrero/2022', 'DD/MON/YYYY'), 12000);
INSERT INTO LW_UBICACIONES VALUES (default, 'Barranquilla',to_date('1/Febrero/2022', 'DD/MON/YYYY'), 0);
INSERT INTO LW_UBICACIONES VALUES (default, 'Barranquilla', to_date('1/Enero/2022', 'DD/MON/YYYY'), 0);


INSERT INTO LW_ROLES VALUES('ADMIN');
INSERT INTO LW_ROLES VALUES('CLIENTE');

INSERT INTO LW_USUARIOS VALUES ('Benito Lopez', 'CLIENTE', 'Benito1234');
INSERT INTO LW_USUARIOS VALUES ('Juanito Suarez', 'CLIENTE', 'Juanito1234');
INSERT INTO LW_USUARIOS VALUES ('Valentina Pasos', 'ADMIN', 'Valentina1234');

INSERT INTO LW_FACTURAS VALUES (default,'Benito Lopez', to_date('1/Enero/2022', 'DD/MON/YYYY'),2000);
INSERT INTO LW_FACTURAS VALUES (default,'Juanito Suarez', to_date('1/Enero/2022', 'DD/MON/YYYY'),3000);
INSERT INTO LW_FACTURAS VALUES (default,'Benito Lopez',to_date('1/Febrero/2022', 'DD/MON/YYYY'),2500);
INSERT INTO LW_FACTURAS VALUES (default,'Juanito Suarez',to_date('1/Febrero/2022', 'DD/MON/YYYY'),4000);

INSERT INTO LW_SOLICITUDES VALUES(default, 'Benito Lopez', 1, 'F', 'Error en la fecha de mi factura');
INSERT INTO LW_SOLICITUDES VALUES(default, 'Juanito Suarez', 4, 'T', 'El precio no coincide con lo acordado');

INSERT INTO LW_MENSAJES VALUES(default, 'Benito Lopez', 20);
INSERT INTO LW_MENSAJES VALUES(default, 'Juanito Suarez', 15);
INSERT INTO LW_MENSAJES VALUES(default, 'Juanito Suarez', 120);

INSERT INTO LW_TARIFAHORARIOS VALUES(default, 'Benito Lopez', to_date('00:00','HH24/MI'),to_date('12:00','HH24/MI'), 200);
INSERT INTO LW_TARIFAHORARIOS VALUES(default, 'Benito Lopez', to_date('12:00','HH24/MI'),to_date('23:59','HH24/MI'), 250);
INSERT INTO LW_TARIFAHORARIOS VALUES(default, 'Juanito Suarez', to_date('00:00','HH24/MI'),to_date('23:59','HH24/MI'), 150);

INSERT INTO LW_TARIFACARACTERES VALUES(default, 'Benito Lopez', 0, 200, 800);
INSERT INTO LW_TARIFACARACTERES VALUES(default, 'Juanito Suarez',0, 100, 400);
INSERT INTO LW_TARIFACARACTERES VALUES(default, 'Juanito Suarez', 100, 200, 800);

INSERT INTO LW_TARIFATIEMPOS VALUES(default, 'Benito Lopez', 0, 5, 300);
INSERT INTO LW_TARIFATIEMPOS VALUES(default, 'Benito Lopez', 5, 10, 600);
INSERT INTO LW_TARIFATIEMPOS VALUES(default, 'Juanito Suarez', 0, 10, 500);

INSERT INTO LW_TARIFAUBICACIONES VALUES(default, 'Benito Lopez', 'Bogotá', 600);
INSERT INTO LW_TARIFAUBICACIONES VALUES(default, 'Benito Lopez', 'Cali', 400);
INSERT INTO LW_TARIFAUBICACIONES VALUES(default, 'Juanito Suarez','Bogotá', 400);
INSERT INTO LW_TARIFAUBICACIONES VALUES(default, 'Juanito Suarez', 'Medellín', 400);