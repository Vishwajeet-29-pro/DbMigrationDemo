ALTER TABLE _employee ADD COLUMN address_id INT, ADD CONSTRAINT fk_employee_address FOREIGN KEY (address_id) REFERENCES _address (id);
ALTER TABLE _address ADD COLUMN employee_id INT, ADD CONSTRAINT fk_address_employee FOREIGN KEY (employee_id) REFERENCES _employee (id);
