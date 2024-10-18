-- Create tables with inline foreign keys
CREATE DATABASE IF NOT EXISTS office_building_management;
# USE office_building_management;
CREATE TABLE company
(
    company_id      BIGINT  NOT NULL AUTO_INCREMENT,
    business_field  VARCHAR(255),
    charter_capital DECIMAL(38, 2),
    company_name    VARCHAR(255),
    employee_count  INTEGER NOT NULL,
    floor_area      DECIMAL(38, 2),
    office_address  VARCHAR(255),
    phone_number    VARCHAR(255),
    tax_code        VARCHAR(255),
    PRIMARY KEY (company_id)
) ENGINE = InnoDB;

CREATE TABLE company_employee
(
    employee_id   BIGINT NOT NULL AUTO_INCREMENT,
    date_of_birth DATE,
    full_name     VARCHAR(255),
    id_number     VARCHAR(255),
    phone_number  VARCHAR(255),
    company_id    BIGINT,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (company_id) REFERENCES company (company_id)
) ENGINE = InnoDB;

CREATE TABLE access_card
(
    card_id     BIGINT NOT NULL AUTO_INCREMENT,
    employee_id BIGINT,
    PRIMARY KEY (card_id),
    UNIQUE KEY  (employee_id),
    FOREIGN KEY (employee_id) REFERENCES company_employee (employee_id)
) ENGINE = InnoDB;

CREATE TABLE access_history
(
    access_id    BIGINT NOT NULL AUTO_INCREMENT,
    access_type  ENUM ('IN','OUT'),
    access_point VARCHAR(255),
    access_time  DATETIME(6),
    card_id      BIGINT,
    PRIMARY KEY (access_id),
    FOREIGN KEY (card_id) REFERENCES access_card (card_id)
) ENGINE = InnoDB;

CREATE TABLE building_employee
(
    employee_id   BIGINT  NOT NULL AUTO_INCREMENT,
    address       VARCHAR(255),
    date_of_birth DATE,
    full_name     VARCHAR(255),
    level         INTEGER NOT NULL,
    phone_number  VARCHAR(255),
    position      VARCHAR(255),
    PRIMARY KEY (employee_id)
) ENGINE = InnoDB;

CREATE TABLE employee_salary
(
    salary_id     BIGINT  NOT NULL AUTO_INCREMENT,
    base_salary   DECIMAL(38, 2),
    salary_month         INTEGER NOT NULL,
    service_bonus DECIMAL(38, 2),
    total_salary  DECIMAL(38, 2),
    year          INTEGER NOT NULL,
    employee_id   BIGINT,
    PRIMARY KEY (salary_id),
    FOREIGN KEY (employee_id) REFERENCES building_employee (employee_id)
) ENGINE = InnoDB;

CREATE TABLE services
(
    service_id   BIGINT NOT NULL AUTO_INCREMENT,
    base_price   DECIMAL(38, 2),
    service_name VARCHAR(255),
    service_type VARCHAR(255),
    PRIMARY KEY (service_id)
) ENGINE = InnoDB;

CREATE TABLE service_assignment
(
    assignment_id BIGINT NOT NULL AUTO_INCREMENT,
    employee_id   BIGINT,
    service_id    BIGINT,
    PRIMARY KEY (assignment_id),
    FOREIGN KEY (employee_id) REFERENCES building_employee (employee_id),
    FOREIGN KEY (service_id) REFERENCES services (service_id)
) ENGINE = InnoDB;

CREATE TABLE service_usage
(
    usage_id   BIGINT NOT NULL AUTO_INCREMENT,
    end_date   DATE,
    price      DECIMAL(38, 2),
    start_date DATE,
    company_id BIGINT,
    service_id BIGINT,
    current_price DECIMAL(10, 2),
    PRIMARY KEY (usage_id),
    FOREIGN KEY (company_id) REFERENCES company (company_id),
    FOREIGN KEY (service_id) REFERENCES services (service_id)
) ENGINE = InnoDB;