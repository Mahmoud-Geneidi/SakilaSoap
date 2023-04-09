


# Sakila Web Services
This project provides Soap web services for the Sakila schema. Services are for actor and film tables , can be used to retrieve, create, update, and delete data from the Sakila database.

## API Documentation
You can find the **API documentation** for this project here ("https://documenter.getpostman.com/view/26734747/2s93XsYRtE"). The documentation provides detailed information on how to use the web services and what parameters they accept.

## Getting Started
To use this project, you will need to have access to a **Sakila schema**.

*Clone the repository to your local machine: git clone https://github.com/Mahmoud-Geneidi/SakilaSoap.git

*Navigate to the project directory: cd sakila-web-services

*Configure **pom.xml** and **persistence.xml** and **hibernate.properties** to your tomcat server configurations.

*Deploy the application on tomcat server using command **"mvn clean install tomcat7:deploy"**

The web services will now be available at http://localhost:9090/Sakila. You can use a tool like Postman to interact with the services.

## Web Services
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
