document.getElementById("registerForm").addEventListener("submit", function(event) {
    event.preventDefault();

    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    var data = {
        "username": username,
        "email": email,
        "password": password
    };

    fetch('/api/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.text();
    })
    .then(message => {
        document.getElementById("message").innerHTML = message;
        document.getElementById("message").classList.remove("error");
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
        document.getElementById("message").innerHTML = "Registration failed!";
        document.getElementById("message").classList.add("error");
    });

    // Clear form fields after submission
    document.getElementById("registerForm").reset();
});
