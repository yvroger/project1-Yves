let loginButton = document.getElementById('login');
let usernameInput = document.getElementById('username');
let passwordInput = document.getElementById('password');

function login(event) {
    event.preventDefault();

    const loginInfo = {
        'username': usernameInput.value,
        'password': passwordInput.value
    };

    fetch('http://127.0.0.1:7000/xaclogin', { 
        method: 'POST',
        credentials: 'include',
        headers: {
            'Content-Type': 'application.json'
        },
        body: JSON.stringify(loginInfo)
    }).then((response) => {
        if (response.status === 200) {
            return response.json();
        } else if (response.status === 400) {
            displayInvalidLogin();
        }
    }).then((user) => {
        if (user.userRole.id === 1){
            window.location.href = 'fmAddReimbursement.html'
        }else{
            window.location.href = 'addReimbursement.html'
        }
    })
};

function displayInvalidLogin() {
    let loginForm = document.getElementById('loginform');

    let p = document.createElement('p');
    p.style.color = 'red';
    p.innerHTML = 'INVALID LOGIN!';

    loginForm.appendChild(p);
};

function checkIfUserCurrentlyLoggedIn(event) {
    fetch('http://127.0.0.1:7000/currentuser', {
        'credentials': 'include',
        'method': 'GET'
    }).then((response) => {
        if (response.status === 200) {
            window.location.href = 'addReimbursement.html';
        }
    });
}

loginButton.addEventListener('click', login);
window.addEventListener('load', checkIfUserCurrentlyLoggedIn)