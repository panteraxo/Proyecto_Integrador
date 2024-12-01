create database bd_grupo1;
use bd_grupo1;

INSERT INTO tb_sucursal (nombre_sucursal, direccion, ciudad, departamento, provincia, pais) VALUES
('Sucursal Centro', 'Av. Principal 123', 'Lima', 'Lima', 'Lima', 'Perú'),
('Sucursal Norte', 'Calle Secundaria 456', 'Trujillo', 'La Libertad', 'Trujillo', 'Perú'),
('Sucursal Sur', 'Jr. Tercera 789', 'Arequipa', 'Arequipa', 'Arequipa', 'Perú'),
('Sucursal Este', 'Av. Los Andes 101', 'Cusco', 'Cusco', 'Cusco', 'Perú'),
('Sucursal Oeste', 'Av. Pacifico 202', 'Piura', 'Piura', 'Piura', 'Perú');

INSERT INTO tb_vendedor (apellido_vendedor, direccion, correo, nombre_vendedor, salario, telefono, id_sucursal) VALUES
('Ñahui Rodriguez', 'Av. El Sol 371', 'nahui@correo.com', 'Diego', 3500, '12345678', 1),
('Gonzales Perez', 'Calle Falsa 123', 'gonzales@correo.com', 'María', 4000, '87654321', 2),
('Fernandez Lopez', 'Jr. Las Flores 456', 'fernandez@correo.com', 'Juan', 3200, '23456789', 3),
('Ramirez Soto', 'Av. Los Pinos 789', 'ramirez@correo.com', 'Ana', 3800, '34567890', 4),
('Vargas Castro', 'Jr. La Colina 101', 'vargas@correo.com', 'Luis', 3600, '45678901', 1);

INSERT INTO tb_usuario (nombre_usuario, contrasena) VALUES
('JuanPerez', 'Contraseña123'),
('MariaGonzalez', 'Segura456'),
('CarlosLopez', 'Clave789'),
('AnaMartinez', 'Password321'),
('LuisHernandez', '12345ABC'),
('LauraSanchez', 'QWERTY987'),
('DiegoFernandez', 'MiContraseña!'),
('ElenaTorres', 'Contraseña2023'),
('RicardoDiaz', 'SecurePass!1'),
('SofiaCastillo', 'Passw0rd!');



Select * from tb_usuario;
