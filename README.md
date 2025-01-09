# Banking Application

## Overview
The Banking Application is a Java-based web application that allows users to create and manage their bank accounts. Users can perform various banking operations such as account creation, login, deposit, withdrawal, balance check, fund transfers, and account deletion. The application is built using Advanced Java (Servlets) for the backend and Oracle Database for data storage.

## Features
1. **User Account Management**:
   - Create a new account.
   - Login with valid credentials.
   - Delete an account.

2. **Banking Operations**:
   - Deposit funds.
   - Withdraw funds.
   - Transfer funds between accounts.
   - Check account balance.

3. **Secure Transactions**:
   - User authentication for secure access.
   - Validation to ensure transaction integrity.

## Technologies Used
- **Frontend**: HTML, CSS, JavaScript (for basic UI and form validation).
- **Backend**: Java Servlets (Advanced Java).
- **Database**: Oracle Database for storing user and transaction data.
- **Web Server**: Apache Tomcat or any other servlet container.

## Installation and Setup

### Prerequisites
1. Java Development Kit (JDK) 8 or above.
2. Apache Tomcat Server.
3. Oracle Database.
4. JDBC Driver for Oracle Database.

### Steps to Run the Application
1. **Clone the Repository**:
   ```bash
   git clone [https://github.com/deepshikhavishwakarma/Bank-Application.git]
   ```

2. **Configure the Database**:
   - Create a new Oracle Database schema.
   - Import the SQL file provided in the repository to create required tables.
   - Update the database connection details (username, password, URL) in the application’s configuration file or the servlet code.

3. **Deploy the Application**:
   - Package the application into a WAR file.
   - Deploy the WAR file on the Apache Tomcat server.

4. **Run the Application**:
   - Start the Tomcat server.
   - Access the application in your browser at: `http://localhost:8082/banking-application`

## Database Schema
- **Users Table**: Stores user account details (ID, name, email, password, etc.).
- **Transactions Table**: Logs all transactions (deposit, withdrawal, transfer).

## Usage
1. **Create Account**: Fill out the registration form to create a new account.
2. **Login**: Use your credentials to access your account.
3. **Perform Transactions**: Deposit, withdraw, or transfer funds using the available options.
4. **Check Balance**: View your current account balance.
5. **Delete Account**: Remove your account permanently.

## Screenshots
Add screenshots of your application’s UI to showcase the features. Include images like the login page, account dashboard, and transaction pages.

## Future Enhancements
- Implement two-factor authentication for added security.
- Add support for email notifications for transactions.
- Enhance the UI with modern frameworks like Bootstrap or React.
- Integrate with external payment gateways for additional features.

## License
This project is open-source and available under the [MIT License](LICENSE).

## Contact
For any questions or suggestions, feel free to reach out:
- **Email**: deepshikha2000deep@gmail.com
- **GitHub**: [your-username](https://github.com/deepshikhavishwakarma)

