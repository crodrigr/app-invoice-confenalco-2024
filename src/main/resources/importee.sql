INSERT INTO regiones (nombre) VALUES("CENTRO AMERICA");
INSERT INTO regiones (nombre) VALUES("NORTE AMERICA");
INSERT INTO regiones (nombre) VALUES("SUR AMERICA");
INSERT INTO regiones (nombre) VALUES("EUROPA");
INSERT INTO regiones (nombre) VALUES("ASIA");
INSERT INTO regiones (nombre) VALUES("AFRICA");


INSERT INTO clientes (nombres, apellidos, email, direccion, celular, fecha_nacimiento,region_id) VALUES ("Juan", "Perez", "juan.perez@example.com", "Calle 123, Ciudad", "1234567890", "1995-02-23",1);
INSERT INTO clientes (nombres, apellidos, email, direccion, celular, fecha_nacimiento,region_id) VALUES ("María", "Gómez", "maria.gomez@example.com", "Avenida 456, Pueblo", "9876543210", "1992-03-25",2);
INSERT INTO clientes (nombres, apellidos, email, direccion, celular, fecha_nacimiento,region_id) VALUES ("Carlos", "López", "carlos.lopez@example.com", "Carrera 789, Villa", "5678901234", "1985-03-25",3);
INSERT INTO clientes (nombres, apellidos, email, direccion, celular, fecha_nacimiento,region_id) VALUES ("Laura", "Martínez", "laura.martinez@example.com", "Camino 234, Campo", "6789012345", "1988-03-25",2);
INSERT INTO clientes (nombres, apellidos, email, direccion, celular, fecha_nacimiento,region_id) VALUES ("Pedro", "Sánchez", "pedro.sanchez@example.com", "Ruta 567, Aldea", "7890123456", "1995-03-25",1);
INSERT INTO clientes (nombres, apellidos, email, direccion, celular, fecha_nacimiento,region_id) VALUES ("Ana", "Rodríguez", "ana.rodriguez@example.com", "Sendero 890, Pueblo", "8901234567", "1993-03-25",4);
INSERT INTO clientes (nombres, apellidos, email, direccion, celular, fecha_nacimiento,region_id) VALUES ("Diego", "Hernández", "diego.hernandez@example.com", "Av. Principal 1234, Ciudad", "9012345678", "1987-03-25",2);
INSERT INTO clientes (nombres, apellidos, email, direccion, celular, fecha_nacimiento,region_id)  VALUES ("Sofía", "García", "sofia.garcia@example.com", "Callejón 4567, Pueblo", "3456789012", "1991-03-25",1);

INSERT INTO productos (create_at,nombre,precio) VALUES ("2024-07-08","tv 15",1000);
INSERT INTO productos (create_at,nombre,precio) VALUES ("2024-07-08","xiami pro 11",700);
INSERT INTO productos (create_at,nombre,precio) VALUES ("2024-07-08","tv 65",2000);
INSERT INTO productos (create_at,nombre,precio) VALUES ("2024-07-08","iphone pro 13",3000);

INSERT INTO facturas (create_at,descripcion,observacion,cliente_id) VALUES ("2024-07-01","observacion","descripcion",1);
INSERT INTO facturas (create_at,descripcion,observacion,cliente_id) VALUES ("2024-07-02","observacion","descripcion",1);
INSERT INTO facturas (create_at,descripcion,observacion,cliente_id) VALUES ("2024-07-03","observacion","descripcion",1);
INSERT INTO facturas (create_at,descripcion,observacion,cliente_id) VALUES ("2024-07-08","observacion","descripcion",1);

INSERT INTO items_factura (cantidad,producto_id,factura_id) VALUES (2,1,1);
INSERT INTO items_factura (cantidad,producto_id,factura_id) VALUES (1,2,1);
INSERT INTO items_factura (cantidad,producto_id,factura_id) VALUES (2,3,2);
INSERT INTO items_factura (cantidad,producto_id,factura_id) VALUES (1,4,2);




