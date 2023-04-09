Sakila Web Services
This project provides four web services for the Sakila schema. Two services are for the actor table and the other two are for the film table. These services can be used to retrieve, create, update, and delete data from the Sakila database.

API Documentation
You can find the API documentation for this project here. The documentation provides detailed information on how to use the web services and what parameters they accept.

Getting Started
To use this project, you will need to have access to a Sakila database. You will also need to have Node.js and npm installed on your machine.

Clone the repository to your local machine: git clone https://github.com/your-username/sakila-web-services.git
Navigate to the project directory: cd sakila-web-services
Install the dependencies: npm install
Start the server: npm start
The web services will now be available at http://localhost:3000. You can use a tool like Postman to interact with the services.

Web Services
/actors
GET /actors
Retrieve a list of all actors in the actor table.

GET /actors/:id
Retrieve a single actor with the specified id.

POST /actors
Create a new actor in the actor table.

PUT /actors/:id
Update an existing actor with the specified id.

DELETE /actors/:id
Delete an actor with the specified id.

/films
GET /films
Retrieve a list of all films in the film table.

GET /films/:id
Retrieve a single film with the specified id.

POST /films
Create a new film in the film table.

PUT /films/:id
Update an existing film with the specified id.

DELETE /films/:id
Delete a film with the specified id.