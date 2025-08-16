QR Code API

A simple API to generate QR Codes from URLs or text.

🌟 Features

Generate QR Codes from a link or text.

Return the QR Code as a PNG image.

Simple and fast API for web or mobile integration.

🔗 Endpoints
GET /api/qrcode

Generates a QR Code from the provided link.

Query Parameters:

Parameter	Type	Description
link	string	Link or text to generate QR Code

Request Example:

GET http://localhost:8080/api/qrcode?link=https://www.google.com


Response:

Returns the QR Code image in PNG format.

🛠 Technologies

Java 17+

Spring Boot

ZXing (for QR Code generation)

🚀 How to Run

Clone the project:

git clone <your-repository>


Navigate to the project folder:

cd qr-code-api


Run the application:

./mvnw spring-boot:run


Access the endpoint via browser or tools like Postman.
