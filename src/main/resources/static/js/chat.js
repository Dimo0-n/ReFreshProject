// Afișează/ascunde fereastra de chat
function toggleChat() {
    var chatBox = document.getElementById("chatBox");
    if (chatBox.style.display === "none" || chatBox.style.display === "") {
        chatBox.style.display = "block";
    } else {
        chatBox.style.display = "none";
    }
}

// Trimite un mesaj predefinit (din butoanele sugestiilor)
function sendMessage(message) {
    appendMessage('User', message); // Afișează mesajul utilizatorului
    sendToServer(message); // Trimite mesajul la server
}

// Trimite mesajul introdus de utilizator
function sendUserMessage() {
    const inputField = document.getElementById("chatInput");
    const message = inputField.value.trim();
    if (message) {
        appendMessage('User', message);
        sendToServer(message); // Trimite mesajul la server
        inputField.value = ''; // Curăță câmpul de input
    }
}

// Adaugă mesajul în chat (pentru utilizator sau bot)
function appendMessage(sender, message) {
    const chatMessages = document.querySelector('.chat-messages');
    const messageElement = document.createElement('div');
    messageElement.classList.add('chat-message');
    messageElement.innerHTML = `<strong>${sender}:</strong> ${message}`;
    chatMessages.appendChild(messageElement);
    chatMessages.scrollTop = chatMessages.scrollHeight;
}

// Trimite mesajul la server folosind AJAX (fetch)
function sendToServer(message) {
    fetch('/chat', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ message: message })
    })
        .then(response => response.json())
        .then(data => {
            if (data.reply) {
                appendMessage('Bot', data.reply); // Afișează răspunsul de la server
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}