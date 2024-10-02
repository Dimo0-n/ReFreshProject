<p align="center">
  <img src="https://github.com/user-attachments/assets/a4c22c59-c24e-40d0-965b-b44a511bf6e5" alt="Image Description" width="350"/>
</p>
<p align="center"><b style="font-size: xx-large;">Trash to Ca$h</b></p>

## Table of Contents
- [About](#-about)
- [How to Build](#-how-to-build)
- [Key Features](#-key-features)
- [Contributors](#%EF%B8%8F-contributors)

## 🚀 About

**ReFreshAI** is a platform powered by AI, developed to revolutionize recycling in Moldova. It enables users to sell and buy recyclable materials through an ecomarketplace, fostering a circular economy. The platform leverages machine learning to generate product listings, simplifying the process of connecting sellers and buyers of recyclables.

This project was created using **Java Spring Boot**, **Thymeleaf**, **mySQL** and integrated with the **Ollama AI** model for product generation. The main challenges involved optimizing the recommendation algorithm and ensuring seamless AI integration.

<p align="center">
  <img src="https://github.com/user-attachments/assets/62ce1cda-6e39-4053-bffb-dd84d7267444" alt="Index page" />
</p>

## 📝 How to Build

To build the packages, follow these steps:

```shell
# Open a terminal (Command Prompt, PowerShell, or Terminal for macOS/Linux)

# Ensure Git is installed
# Visit https://git-scm.com to download and install console Git if not already installed

# Clone the repository
git clone https://github.com/Dimo0-n/ReFreshProject.git

# Navigate to the project directory
cd ReFreshProject

# Check if Java is installed
java -version  # Ensure that Java JDK 17+ is installed
# If not installed, download Java JDK.

# Check if Maven is installed
mvn -version  # Ensure Apache Maven is installed. If not, install Maven via the official website.

# Ensure Docker is installed and running
# Visit https://www.docker.com/get-started to download and install Docker

# Run MySQL using Docker
docker run --name my-mysql-market -e MYSQL_ROOT_PASSWORD=qwertyuiop -p 3308:3306 -d mysql:latest

# Run the Ollama model for AI-powered features
docker run -d -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama
ollama run llama3.1:8b

# Run the Spring Boot application
mvn spring-boot:run  

# Access the Application. Once the application starts, open your browser and navigate to:
http://localhost:8080

```

## 🔥 Key Features

Trebuie screenuri si gif-uri

## 🍻 Contributors

For more details about our product, services, or any general information regarding ReFreshAI, feel free to reach out to us. We are here to provide support and answer any questions you may have. Below are the best ways to contact our team:

<a href="https://github.com/Dimo0-n"><img src="https://avatars.githubusercontent.com/u/77103943?v=4" title="Frimu Dumitru" width="50" height="50"></a>
<a href="https://github.com/mihaela-chiaburu"><img src="https://avatars.githubusercontent.com/u/145827544?v=4" title="Chiaburu Mihaela" width="50" height="50"></a>
<a href="https://github.com/0Alina"><img src="https://avatars.githubusercontent.com/u/143406895?v=4" title="Glodea Alina" width="50" height="50"></a>
<a href="https://github.com/IonutBerdila"><img src="https://avatars.githubusercontent.com/u/145832863?v=4" title="Berdila Ionut" width="50" height="50"></a>
<a href="https://github.com/anatolguidea"><img src="https://avatars.githubusercontent.com/u/135653374?v=4" title="Guidea Anatol" width="50" height="50"></a>

[Back to top](#top)
