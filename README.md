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

1. **User Authentication**  
Register and Login functionality for users: Users can create an account and log in to access personalized features.

<p align="center">
  <img src="https://github.com/user-attachments/assets/5e0e01fa-ff5e-4fe7-9d06-97c9407ab3ee" width="1000"/>
</p>

2. **Shop Page**  
Browse Products with multiple filtering options:

<p align="center">
  <img src="https://github.com/user-attachments/assets/1d8795de-1c7e-4f00-b11f-54a9bb6a1861" width="1000"/>
</p>
Filter by category, region, price, and sort by price or posting date.

<p align="center">
  <img src="https://github.com/user-attachments/assets/fa77c463-4308-46e8-a85d-dc3d51ec672f" width="1000"/>
</p>
Search for products using keywords.

<p align="center">
  <img src="https://github.com/user-attachments/assets/b254455c-f844-414b-8b09-58006ea69df1" width="1000"/>
</p>


3. **Product Details**  
Click on a product to view its details.

<p align="center">
  <img src="https://github.com/user-attachments/assets/d97b043e-5e55-4c69-8a8a-5b89123b5e5d" width="1000"/>
</p>

Users can add, edit, or delete reviews.

<p align="center">
  <img src="https://github.com/user-attachments/assets/384e66dc-7c7f-4205-9dfa-50dcb9d1b439" width="1000"/>
</p>


4. **Cart & Checkout**  
Add products to the cart with the ability to adjust quantities.

<p align="center">
  <img src="https://github.com/user-attachments/assets/db71b9ba-9d6e-441f-92e2-6e1ec43bf2fb" width="1000"/>
</p>

Proceed to checkout and confirm your purchase on the payment page.

<p align="center">
  <img src="https://github.com/user-attachments/assets/8c0971fa-80f2-4d31-9322-36ef7d67ee32" width="1000"/>
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/62e7ec99-de35-4b3b-8511-14dd8c1a293b" width="1000"/>
</p>
<p align="center">
  <img src="https://github.com/user-attachments/assets/3faf77dc-8ca2-4bba-a3c6-b8fe4cb772cb" width="600"/>
</p>


5. **AI-powered Product Addition**  
Add new products with AI assistance:  
AI generates detailed descriptions from titles and keywords.

<p align="center">
  <img src="https://github.com/user-attachments/assets/73717609-fa23-4230-b0bf-08919fade134" width="1000"/>
</p>

AI provides a recommended price based on the category.

<p align="center">
  <img src="https://github.com/user-attachments/assets/1d444604-55e3-45e4-8053-8f994a3f289c" width="1000"/>
</p>


6. **User Profile Management**  
View and edit profile details, change your password, and manage your products.

<p align="center">
  <img src="https://github.com/user-attachments/assets/79bc57fe-f545-4706-880c-d60f34e51691" width="1000"/>
</p>

Products can be edited, activated/deactivated, or deleted from the profile.

<p align="center">
  <img src="https://github.com/user-attachments/assets/15e21eb8-ec08-4cc8-8559-7e44f67b7128" width="1000"/>
</p>


7. **AI Chat Support**  
Integrated AI chat to assist with eco-related and marketplace questions.  
If asked questions outside the eco-topic, the chat reorients users towards relevant content.

<p align="center">
  <img src="https://github.com/user-attachments/assets/ff0db038-376b-4bb7-bd3a-b0c70d6baeb7" width="1000"/>
</p>


8. **Contact Page**  
Send messages directly to the contributors of the platform.

<p align="center">
  <img src="https://github.com/user-attachments/assets/c1d18937-debc-488e-9e8a-418fe1ce9c4b" width="1000"/>
</p>



## 🍻 Contributors

For more details about our product or any general information, feel free to reach out to us.

<a href="https://github.com/Dimo0-n"><img src="https://avatars.githubusercontent.com/u/77103943?v=4" title="Frimu Dumitru" width="50" height="50"></a>
<a href="https://github.com/mihaela-chiaburu"><img src="https://avatars.githubusercontent.com/u/145827544?v=4" title="Chiaburu Mihaela" width="50" height="50"></a>
<a href="https://github.com/0Alina"><img src="https://avatars.githubusercontent.com/u/143406895?v=4" title="Glodea Alina" width="50" height="50"></a>
<a href="https://github.com/IonutBerdila"><img src="https://avatars.githubusercontent.com/u/145832863?v=4" title="Berdila Ionut" width="50" height="50"></a>
<a href="https://github.com/anatolguidea"><img src="https://avatars.githubusercontent.com/u/135653374?v=4" title="Guidea Anatol" width="50" height="50"></a>

[Back to top](#top)
