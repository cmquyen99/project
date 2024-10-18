const API_URL = 'http://localhost:8234/api';

function openTab(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";

    // Load data based on the selected tab
    switch(tabName) {
        case 'Companies': loadCompanies(); break;
        case 'CompanyEmployees': loadCompanyEmployees(); break;
        case 'AccessCards': loadAccessCards(); break;
        case 'AccessHistory': loadAccessHistory(); break;
        case 'BuildingEmployees': loadBuildingEmployees(); break;
        case 'EmployeeSalaries': loadEmployeeSalaries(); break;
        case 'Services': loadServices(); break;
        case 'ServiceAssignments': loadServiceAssignments(); break;
        case 'ServiceUsages': loadServiceUsages(); break;
    }
}

function fetchData(endpoint) {
    return fetch(`${API_URL}/${endpoint}`)
        .then(response => response.json())
        .catch(error => {
            console.error('Error:', error);
            document.getElementById(endpoint).innerHTML = `<p>Error loading data: ${error.message}</p>`;
        });
}

function displayData(data, elementId, columns) {
    const element = document.getElementById(elementId);
    if (data.length === 0) {
        element.innerHTML = '<p>No data found.</p>';
        return;
    }

    let tableHtml = `<table><thead><tr>`;
    columns.forEach(column => {
        tableHtml += `<th>${column.header}</th>`;
    });
    // tableHtml += `<th>Actions</th></tr></thead><tbody>`;

    data.forEach(item => {
        tableHtml += `<tr>`;
        columns.forEach(column => {
            tableHtml += `<td>${column.value(item)}</td>`;
        });
        // tableHtml += `<td><button onclick="editItem('${elementId}', ${item.id})">Edit</button> <button onclick="deleteItem('${elementId}', ${item.id})">Delete</button></td></tr>`;
    });

    tableHtml += `</tbody></table>`;
    element.innerHTML = tableHtml;
}

function loadCompanies() {
    fetchData('companies').then(companies => {
        displayData(companies, 'Companies', [
            { header: 'Company Name', value: item => item.companyName },
            { header: 'Business Field', value: item => item.businessField },
            { header: 'Charter Capital', value: item => item.charterCapital },
            { header: 'Floor Area (m2)', value: item => item.floorArea},
            { header: 'Employee Count', value: item => item.employeeCount }
        ]);
    });
}

function loadCompanyEmployees() {
    fetchData('company-employees').then(employees => {
        displayData(employees, 'CompanyEmployees', [
            { header: 'Full Name', value: item => item.fullName },
            { header: 'ID Number', value: item => item.idNumber },
            { header: 'Phone Number', value: item => item.phoneNumber },
            { header: 'Company', value: item => item.company ? item.company.companyName : 'N/A' }
        ]);
    });
}

function loadAccessCards() {
    fetchData('access-cards').then(cards => {
        displayData(cards, 'AccessCards', [
            { header: 'Card ID', value: item => item.cardId },
            { header: 'Employee', value: item => item.employee ? item.employee.fullName : 'N/A' }
        ]);
    });
}

function loadAccessHistory() {
    fetchData('access-history').then(history => {
        displayData(history, 'AccessHistory', [
            { header: 'Access Type', value: item => item.accessType },
            { header: 'Access Point', value: item => item.accessPoint },
            { header: 'Access Time', value: item => new Date(item.accessTime).toLocaleString() },
            { header: 'Card', value: item => item.card ? item.card.cardId : 'N/A' }
        ]);
    });
}

function loadBuildingEmployees() {
    fetchData('building-employees').then(employees => {
        displayData(employees, 'BuildingEmployees', [
            { header: 'Full Name', value: item => item.fullName },
            { header: 'Position', value: item => item.position },
            { header: 'Level', value: item => item.level },
            { header: 'Phone Number', value: item => item.phoneNumber }
        ]);
    });
}

function loadEmployeeSalaries() {
    fetchData('employee-salaries').then(salaries => {
        displayData(salaries, 'EmployeeSalaries', [
            { header: 'Employee', value: item => item.employee ? item.employee.fullName : 'N/A' },
            { header: 'Base Salary', value: item => item.baseSalary },
            { header: 'Service Bonus', value: item => item.serviceBonus },
            { header: 'Total Salary', value: item => item.totalSalary },
            { header: 'Month/Year', value: item => `${item.salaryMonth}/${item.year}` }
        ]);
    });
}

function loadServices() {
    fetchData('services').then(services => {
        displayData(services, 'Services', [
            { header: 'Service Name', value: item => item.serviceName },
            { header: 'Base Price', value: item => item.basePrice },
            { header: 'Service Type', value: item => item.serviceType }
        ]);
    });
}

function loadServiceAssignments() {
    fetchData('service-assignments').then(assignments => {
        displayData(assignments, 'ServiceAssignments', [
            { header: 'Employee', value: item => item.employee ? item.employee.fullName : 'N/A' },
            { header: 'Service', value: item => item.service ? item.service.serviceName : 'N/A' }
        ]);
    });
}

function loadServiceUsages() {
    fetchData('service-usages').then(usages => {
        displayData(usages, 'ServiceUsages', [
            { header: 'Company', value: item => item.company ? item.company.companyName : 'N/A' },
            { header: 'Service', value: item => item.service ? item.service.serviceName : 'N/A' },
            { header: 'Start Date', value: item => item.startDate },
            { header: 'End Date', value: item => item.endDate },
            { header: 'Price', value: item => item.price },
            { header: 'Current Price', value: item => item.currentPrice }
        ]);
    });
}
function loadBuildingAccessList() {
    const startDate = document.getElementById('start-date').value;
    const endDate = document.getElementById('end-date').value;

    let url = `${API_URL}/access-history/building-access-list`;
    if (startDate) url += `?start=${encodeURIComponent(startDate)}`;
    if (endDate) url += `${startDate ? '&' : '?'}end=${encodeURIComponent(endDate)}`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            displayBuildingAccessList(data);
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById('building-access-list-content').innerHTML = `<p>Error loading data: ${error.message}</p>`;
        });
}

function displayBuildingAccessList(data) {
    const content = document.getElementById('building-access-list-content');
    if (data.length === 0) {
        content.innerHTML = '<p>No data found.</p>';
        return;
    }

    let tableHtml = `
        <table>
            <thead>
                <tr>
                    <th>Employee Name</th>
                    <th>Company Name</th>
                    <th>Details</th>
                </tr>
            </thead>
            <tbody>
    `;

    data.forEach(item => {
        tableHtml += `
            <tr>
                <td>${item.employeeName}</td>
                <td>${item.companyName}</td>
                <td><button onclick="showAccessDetails(${JSON.stringify(item.accessDetails).replace(/"/g, '&quot;')})">View Details</button></td>
            </tr>
        `;
    });

    tableHtml += `
            </tbody>
        </table>
    `;

    content.innerHTML = tableHtml;
}

function showAccessDetails(details) {
    let detailsHtml = `
        <table>
            <thead>
                <tr>
                    <th>Time</th>
                    <th>Type</th>
                    <th>Location</th>
                </tr>
            </thead>
            <tbody>
    `;

    details.forEach(detail => {
        detailsHtml += `
            <tr>
                <td>${new Date(detail.time).toLocaleString()}</td>
                <td>${detail.type}</td>
                <td>${detail.location}</td>
            </tr>
        `;
    });

    detailsHtml += `
            </tbody>
        </table>
    `;

    // Hiển thị chi tiết trong một modal hoặc một phần tử khác trên trang
    // Ví dụ: sử dụng alert để hiển thị (trong thực tế, bạn có thể sử dụng một modal đẹp hơn)
    alert(detailsHtml);
}

// Thêm BuildingAccessList vào danh sách các tab được khởi tạo
window.onload = function() {
    document.getElementsByClassName("tablinks")[0].click();
    // Đặt giá trị mặc định cho trường ngày
    document.getElementById('start-date').value = new Date(new Date().setFullYear(new Date().getFullYear() - 1)).toISOString().slice(0, 16);
    document.getElementById('end-date').value = new Date().toISOString().slice(0, 16);
};
// Open the Companies tab by default when the page loads
window.onload = function() {
    document.getElementsByClassName("tablinks")[0].click();
};