DROP TABLE IF EXISTS EMPLOYEE;
DROP TABLE IF EXISTS DEPARTMENT;
DROP TABLE IF EXISTS PHONE;

CREATE TABLE PHONE (
                       phone_id INT PRIMARY KEY,
                       number VARCHAR(15) NOT NULL
);

CREATE TABLE DEPARTMENT (
                            dept_id INT PRIMARY KEY,
                            name VARCHAR(100) NOT NULL
);

CREATE TABLE EMPLOYEE (
                          emp_id INT PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          age INT NOT NULL,
                          department INT NOT NULL,
                          salary BIGINT NOT NULL,
                          phone_id INT,

                          CONSTRAINT fk_employee_department
                              FOREIGN KEY (department)
                                  REFERENCES DEPARTMENT(dept_id),

                          CONSTRAINT fk_employee_phone
                              FOREIGN KEY (phone_id)
                                  REFERENCES PHONE(phone_id)
);