# ACCOUNT - REST Controller

## Description

The "ACCOUNT - REST Controller" project aims to provide a convenient API wrapper for utilizing the FABRICK platform's services to manage bank accounts.

## Used Technologies

The technologies used in this project are the following:

- ***Spring Web***: Module of the SPRING framework for exposing REST APIs.
- ***Spring Test***: Module of the SPRING framework for managing tests.
- ***Maven***: System for dependency management and automation of build, test operations.

## Features

- ***Balance Retrieval***
- ***Transaction History***
- ***Money Transfers***

## Setup Instructions
To use the project, follow these steps:

1. Clone the repository to your local machine.
2. Ensure you have Maven installed. If not, download and install it from Maven's official website.
3. Execute the build commands and run the project.
4. Access the API endpoints using a tool like Postman (but you can also use your web browser)
5. Provide the necessary parameters and request bodies as described below.

## API Endpoints
The API endpoints in this project are documented using OpenAPI/Swagger. You can explore and test the endpoints easily using the Swagger UI.

### Accessing the API Documentation

To access the API documentation, follow these steps:

1. Start the project and ensure it's running.
2. Open your web browser and navigate to [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
### Using the API Documentation

1. Once you're on the Swagger UI page, you'll see a list of available endpoints.
2. Click on an endpoint to expand it and see details about the endpoint, including request parameters and request/response examples.
3. You can test the endpoint directly from Swagger UI by providing input parameters and clicking the "Try it out" button.

### Endpoints Overview
#### Get Account Balance
Retrieves the balance of a specific cash account.

- **Endpoint**: GET `/api/accounts/{accountId}/balance/` 
- **Description**: Fetches the balance of the specified account.
- **Parameters**:
    - `{accountId}`: The unique identifier of the account.
- **Response**:
    - Status: 200 OK (if successful)
    - Body: JSON representation of the account balance.

#### Get Account Transactions

Retrieve a list of transactions for a specific account within a given time range.

- **Endpoint**: GET `/api/accounts/{accountId}/transactions`
- **Description**: Retrieves a list of transactions that occurred within the specified date range for the given account.
- **Parameters**:
    - `{accountId}`: The unique identifier of the account.
    - `fromAccountingDate`: The start date of the date range (format: YYYY-MM-DD).
    - `toAccountingDate`: The end date of the date range (format: YYYY-MM-DD).
- **Response**:
    - Status: 200 OK (if successful)
    - Body: JSON array representation with the list of the transactions.

#### Create Money Transfer

Make a new money transfer.

- **Endpoint**: POST `/api/accounts/{accountId}/moneyTransfer`
- **Description**: Makes a money transfer from the specified account to another account.
- **Parameters**:
    - `{accountId}`: The unique identifier of the account.
- **Request Body Fields**:
  - `creditorName` (string): The name of the creditor.
  - `creditorAccountCode` (string): The IBAN of the credutor's account.
  - `description` (string): A description of the payment.
  - `currency` (string): The currency of the payment (e.g., EUR).
  - `amount` (string): The amount of money to be transferred.
  - `executionDate` (string): The date when the transfer should be executed (format: YYYY-MM-DD).
- **Response**:
  - Status: 200 OK (if successful)
  - Status: 400 Bad Request (if there's an error)
  - Body: JSON representation of the money transfer response or error message.

