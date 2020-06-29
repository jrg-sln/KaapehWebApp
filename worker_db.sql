-- bitácora del sistema
CREATE TABLE log_access(
    id          serial PRIMARY KEY,
    ip_address  VARCHAR(20) NOT NULL,
    date_access VARCHAR(30) NOT NULL,
	email       VARCHAR(40),
	resource    VARCHAR(30) NOT NULL
);

-- Los trabajadores van a estar asociados a un tipo
CREATE TABLE worker_type (
    id          serial PRIMARY KEY,
    name        VARCHAR(20) NOT NULL,
    description VARCHAR(100) NOT NULL,
    created     TIMESTAMP DEFAULT NOW(),
	vigent      BOOLEAN DEFAULT True
);

INSERT INTO worker_type (name, description) VALUES ('ADMINISTRADOR', 'Administrador general del sistema, tiene acceso a CRUD general');
INSERT INTO worker_type (name, description) VALUES ('SUPERVISOR', 'Acceso a consulta de otros usuarios y asistencia.');
INSERT INTO worker_type (name, description) VALUES ('TRABAJADOR', 'Acceso a asistencia.');

-- Los trabajadores van a estar asociados a una área
CREATE TABLE area_depto (
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

-- update worker set pwd='8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918' where id=1