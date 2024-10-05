USE office_management_db;

-- Insert sample data for Company table
INSERT INTO Company (company_name, tax_code, charter_capital, business_field, employee_count, office_address, phone_number, floor_area)
VALUES
    ('Tech Solutions Inc.', '1234567890', 1000000000, 'IT', 50, 'Tầng 5, 123 Đường ABC', '0901234567', 500),
    ('Finance Experts Ltd.', '0987654321', 500000000, 'Tài chính', 30, 'Tầng 3, 123 Đường ABC', '0909876543', 300);

-- Insert sample data for CompanyEmployee table
INSERT INTO Company_Employee (company_id, id_number, full_name, date_of_birth, phone_number)
VALUES
    (1, '001234567', 'Nguyễn Văn A', '1990-01-15', '0912345678'),
    (1, '007654321', 'Trần Thị B', '1992-05-20', '0923456789'),
    (2, '002345678', 'Lê Văn C', '1988-11-10', '0934567890');

-- Insert sample data for Service table
INSERT INTO Services (service_name, service_type, base_price)
VALUES
    ('Vệ sinh', 'Cơ bản', 1000000),
    ('Bảo vệ', 'Cơ bản', 2000000),
    ('Ăn uống', 'Tùy chọn', 1500000),
    ('Trông giữ xe', 'Tùy chọn', 500000),
    ('Bảo trì thiết bị', 'Tùy chọn', 3000000);

-- Insert sample data for BuildingEmployeeController table
INSERT INTO Building_Employee (full_name, date_of_birth, address, phone_number, level, position)
VALUES
    ('Phạm Thị D', '1985-03-25', '456 Đường XYZ', '0945678901', 2, 'Nhân viên vệ sinh'),
    ('Hoàng Văn E', '1980-07-30', '789 Đường MNO', '0956789012', 3, 'Bảo vệ');

-- Insert sample data for ServiceUsage table
INSERT INTO Service_Usage (company_id, service_id, start_date, price)
VALUES
    (1, 1, '2024-01-01', 1050000),
    (1, 2, '2024-01-01', 2100000),
    (2, 1, '2024-01-01', 1000000),
    (2, 2, '2024-01-01', 2000000);

-- Insert sample data for AccessCard table
INSERT INTO Access_Card (employee_id)
VALUES (1), (2), (3);

-- Insert sample data for AccessHistory table
INSERT INTO Access_History (card_id, access_time, access_point, access_type)
VALUES
    (1, '2024-01-02 08:00:00', 'Tầng 1', 'IN'),
    (1, '2024-01-02 17:30:00', 'Tầng 1', 'OUT'),
    (2, '2024-01-02 08:15:00', 'Hầm B1', 'IN'),
    (2, '2024-01-02 18:00:00', 'Hầm B1', 'OUT');

-- Insert sample data for ServiceAssignment table
INSERT INTO Service_Assignment (employee_id, service_id)
VALUES (1, 1), (2, 2);

-- Insert sample data for EmployeeSalary table
INSERT INTO Employee_Salary (employee_id, month, year, base_salary, service_bonus, total_salary)
VALUES
    (1, 1, 2024, 5000000, 500000, 5500000),
    (2, 1, 2024, 6000000, 600000, 6600000);