const API_URL = '/employee';

document.addEventListener('DOMContentLoaded', () => {
    fetchEmployees();

    document.getElementById('addEmployeeForm').addEventListener('submit', handleAddEmployee);
});

async function fetchEmployees() {
    const listContainer = document.getElementById('employee-list');
    const countBadge = document.getElementById('count-badge');

    try {
        const response = await fetch(`${API_URL}/all`);
        if (!response.ok) throw new Error('Failed to fetch');

        const employees = await response.json();
        countBadge.textContent = employees.length;

        listContainer.innerHTML = '';

        if (employees.length === 0) {
            listContainer.innerHTML = '<div class="loading">No employees found. Add one!</div>';
            return;
        }

        employees.forEach(emp => {
            const card = document.createElement('div');
            card.className = 'employee-card';
            card.innerHTML = `
                <div class="emp-info">
                    <h3>${emp.name}</h3>
                    <p><i class="fas fa-envelope"></i> ${emp.email}</p>
                    <p><i class="fas fa-dollar-sign"></i> ${emp.salary.toLocaleString()}</p>
                </div>
                <button class="delete-btn" onclick="deleteEmployee(${emp.id})" title="Remove">
                    <i class="fas fa-trash-alt"></i>
                </button>
            `;
            listContainer.appendChild(card);
        });
    } catch (error) {
        console.error('Error:', error);
        listContainer.innerHTML = '<div class="loading" style="color: var(--danger-color)">Error loading data. Is the server running?</div>';
    }
}

async function handleAddEmployee(e) {
    e.preventDefault();

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const salary = document.getElementById('salary').value;
    const btn = e.target.querySelector('button');

    const originalText = btn.innerHTML;
    btn.innerHTML = '<i class="fas fa-spinner fa-spin"></i> Saving...';
    btn.disabled = true;

    try {
        const response = await fetch(`${API_URL}/save`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ name, email, salary })
        });

        if (response.ok) {
            document.getElementById('addEmployeeForm').reset();
            fetchEmployees();
        } else {
            alert('Failed to save employee');
        }
    } catch (error) {
        alert('Error connecting to server');
    } finally {
        btn.innerHTML = originalText;
        btn.disabled = false;
    }
}

async function deleteEmployee(id) {
    if (!confirm('Are you sure you want to delete this employee?')) return;

    try {
        const response = await fetch(`${API_URL}/delete/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            fetchEmployees();
        } else {
            alert('Failed to delete');
        }
    } catch (error) {
        alert('Error connecting to server');
    }
}
