CREATE TABLE IF NOT EXISTS _department (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS _employee (
    id SERIAL PRIMARY KEY,
    identifier VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    birthdate DATE NOT NULL,
    role VARCHAR(255) NOT NULL,
    department_id INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES _department (id)
);

CREATE TABLE IF NOT EXISTS _address (
    id SERIAL PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    house_number VARCHAR(255) NOT NULL,
    zip_code VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS _department (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS _mission (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    duration INT NOT NULL
);

CREATE TABLE IF NOT EXISTS _employee_mission (
    employee_id INT NOT NULL,
    mission_id INT NOT NULL,
    PRIMARY KEY (employee_id, mission_id),
    FOREIGN KEY (employee_id) REFERENCES _employee (id),
    FOREIGN KEY (mission_id) REFERENCES _mission (id)
);
