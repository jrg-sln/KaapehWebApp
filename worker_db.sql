-- bitácora del sistema
CREATE TABLE log_access(
    id          serial PRIMARY KEY,
    ip_address  VARCHAR(20) NOT NULL,
    date_access VARCHAR(30) NOT NULL,
	email       VARCHAR(40),
	resource    VARCHAR(30) NOT NULL
);

-- Las pantallas del sistema
CREATE TABLE screen (
    id          serial PRIMARY KEY,
    name        VARCHAR(40) NOT NULL,
    description VARCHAR(100) NOT NULL,
    created     TIMESTAMP DEFAULT NOW(),
	vigent      BOOLEAN DEFAULT True
);

INSERT INTO screen (name, description) VALUES ('/KaapehApp/home', 'Muestra la página inicial del sistema');
INSERT INTO screen (name, description) VALUES ('/KaapehApp/log', 'Muestra la bitácora del sistema');
INSERT INTO screen (name, description) VALUES ('/KaapehApp/login', 'Muestra el formulario para inicar sesión en el sistema');
INSERT INTO screen (name, description) VALUES ('/KaapehApp/logout', 'Cierra la sesión del usuario en el sistema');
INSERT INTO screen (name, description) VALUES ('/KaapehApp/listWorkers', 'Muestra la lista de trabajadores');
INSERT INTO screen (name, description) VALUES ('/KaapehApp/addWorker', 'Muestra el formulario para agregar trabajdor/usuario');
INSERT INTO screen (name, description) VALUES ('/KaapehApp/saveWorker', 'Guarda el trabajdor/usuario');
INSERT INTO screen (name, description) VALUES ('/KaapehApp/updateWorker', 'Permite consultar un trabajdor/usuario guardado');
INSERT INTO screen (name, description) VALUES ('/KaapehApp/saveUpdateWorker', 'Actualiza la información de un trabajdor/usuario guardado');
INSERT INTO screen (name, description) VALUES ('/KaapehApp/deleteWorker', 'Elimina un trabajdor/usuario guardado');

-- Los trabajadores van a estar asociados a un tipo
CREATE TABLE worker_type (
    id          serial PRIMARY KEY,
    name        VARCHAR(20) NOT NULL,
    description VARCHAR(100) NOT NULL,
    created     TIMESTAMP DEFAULT NOW(),
	vigent      BOOLEAN DEFAULT True
);

INSERT INTO worker_type (name, description) VALUES ('ADMINISTRADOR', 'Administrador general del sistema, tiene acceso a CRUD general');
INSERT INTO worker_type (name, description) VALUES ('SUPERVISOR', 'Acceso a consulta de otros usuarios del área.');
INSERT INTO worker_type (name, description) VALUES ('TRABAJADOR', 'Acceso al sistema.');

-- Las pantallas del sistema
CREATE TABLE permission (
    id          	serial PRIMARY KEY,
    idworkertype	serial NOT NULL,
    nametype		VARCHAR(20) NOT NULL,
    idscreen		serial NOT NULL,
    namescreen      VARCHAR(40) NOT NULL,
	vigent      	BOOLEAN DEFAULT True
);

-- ADMINISTRADOR tiene acceso a todo
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (1, 'ADMINISTRADOR', 1, '/KaapehApp/home');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (1, 'ADMINISTRADOR', 2, '/KaapehApp/log');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (1, 'ADMINISTRADOR', 3, '/KaapehApp/login');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (1, 'ADMINISTRADOR', 4, '/KaapehApp/logout');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (1, 'ADMINISTRADOR', 5, '/KaapehApp/listWorkers');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (1, 'ADMINISTRADOR', 6, '/KaapehApp/addWorker');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (1, 'ADMINISTRADOR', 7, '/KaapehApp/saveWorker');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (1, 'ADMINISTRADOR', 8, '/KaapehApp/updateWorker');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (1, 'ADMINISTRADOR', 9, '/KaapehApp/saveUpdateWorker');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (1, 'ADMINISTRADOR', 10, '/KaapehApp/deleteWorker');
-- SUPERVISOR tiene acceso a:
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (2, 'SUPERVISOR', 1, '/KaapehApp/home');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (2, 'SUPERVISOR', 3, '/KaapehApp/login');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (2, 'SUPERVISOR', 4, '/KaapehApp/logout');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (2, 'SUPERVISOR', 5, '/KaapehApp/listWorkers');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (2, 'SUPERVISOR', 8, '/KaapehApp/updateWorker');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (2, 'SUPERVISOR', 9, '/KaapehApp/saveUpdateWorker');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (2, 'SUPERVISOR', 10, '/KaapehApp/deleteWorker');
-- SUPERVISOR tiene acceso a:
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (3, 'TRABAJADOR', 1, '/KaapehApp/home');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (3, 'TRABAJADOR', 3, '/KaapehApp/login');
INSERT INTO permission (idworkertype, nametype, idscreen, namescreen) VALUES (3, 'TRABAJADOR', 4, '/KaapehApp/logout');


-- Los trabajadores van a estar asociados a una área
CREATE TABLE worker_area (
    id          serial PRIMARY KEY,
    name        VARCHAR(20) NOT NULL,
    description VARCHAR(100) NOT NULL,
    created     TIMESTAMP DEFAULT NOW(),
	vigent      BOOLEAN DEFAULT True
);

INSERT INTO area_depto (name, description) VALUES ('DIRECCION', 'Dueño y altos mandos.');
INSERT INTO area_depto (name, description) VALUES ('SISTEMAS', 'Equipo de desarrollo');
INSERT INTO area_depto (name, description) VALUES ('CONTABILIDAD', 'Cobranza, viáticos y pagos.');

-- La información de los trabajadores
CREATE TABLE worker (
    id          serial PRIMARY KEY,
    email       VARCHAR(40) NOT NULL,
    pwd         VARCHAR(80) NOT NULL,
    firstname   VARCHAR(20) NOT NULL,
	secondname  VARCHAR(20),
    lastname1   VARCHAR(20) NOT NULL,
	lastname2   VARCHAR(20),
	usertype    INTEGER NOT NULL,
	userarea    INTEGER NOT NULL,
    created     TIMESTAMP DEFAULT NOW(),
	vigent      BOOLEAN DEFAULT True
);

-- contraseña adminadmin
insert into worker (email, pwd, firstname, lastname1, usertype, userarea, vigent)
values ('admin@cd.mx', 'd82494f05d6917ba02f7aaa29689ccb444bb73f20380876cb05d1f37537b7892', 'System', 'Administrator', 1, 1, 't');
