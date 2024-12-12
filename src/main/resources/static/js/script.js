// Открытие модального окна редактирования
function openEditModal() {
    document.getElementById('editModal').style.display = 'block';
}

// Закрытие модального окна
function closeEditModal() {
    document.getElementById('editModal').style.display = 'none';
}

function saveClientChanges() {
    const fullName = document.getElementById('edit-full-name').value;
    const birthDate = document.getElementById('edit-birth-date').value;
    const passportNumber = document.getElementById('edit-passport-number').value;
    const phoneNumber = document.getElementById('edit-phone-number').value;
    const education = document.getElementById('edit-education').value;
    const employment = document.getElementById('edit-employment').value;
    const annualIncome = document.getElementById('edit-annual-income').value;

    const clientData = {
        name: fullName,
        dateOfBirth: birthDate,
        passportNumber: passportNumber,
        phoneNumber: phoneNumber,
        education: education,
        job: employment,
        averageAnnualIncome: annualIncome
    };

    fetch('/api/clients/update', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(clientData)
    }).then(response => {
        if (response.ok) {
            document.getElementById('full-name').innerText = fullName;
            document.getElementById('birth-date').innerText = birthDate;
            document.getElementById('passport-number').innerText = passportNumber;
            document.getElementById('phone-number').innerText = phoneNumber;
            document.getElementById('education').innerText = education;
            document.getElementById('employment').innerText = employment;
            document.getElementById('annual-income').innerText = annualIncome;
            alert('Изменения сохранены!');
        } else {
            alert('Произошла ошибка при сохранении изменений.');
        }
    });

    closeEditModal();
}

function deleteClient() {
    const clientId = document.getElementById('client-id').value;

    if (confirm("Вы уверены, что хотите удалить клиента?")) {
        fetch('/api/clients/' + clientId, {
            method: 'DELETE'
        }).then(response => {
            if (response.ok) {
                alert("Клиент удалён!");
                window.location.href = "/clients";
            } else {
                alert('Произошла ошибка при удалении клиента.');
            }
        });
    }
}

function submitForm() {
    var form = document.getElementById("clientForm");
    var formData = new FormData(form);

    var clientData = {};
    formData.forEach((value, key) => {
        clientData[key] = value;
    });

    fetch('/api/clients', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(clientData)
    }).then(response => {
        if (response.ok) {
            alert('Клиент добавлен!');
        } else {
            alert('Произошла ошибка при добавлении клиента.');
        }
    });

    closeModal();
}

function openModal() {
    document.getElementById("myModal").style.display = "flex";
}

function closeModal() {
    document.getElementById("myModal").style.display = "none";
}

function updateButtonVisibility(userType) {
    if (userType === 1) {
        document.getElementById('edit-button').classList.remove('hidden');
    } else if (userType === 2) {
        document.getElementById('approve-button').classList.remove('hidden');
        document.getElementById('reject-button').classList.remove('hidden');
    }
}

document.addEventListener('DOMContentLoaded', () => {
    const userType = getUserType();
    updateButtonVisibility(userType);
});
