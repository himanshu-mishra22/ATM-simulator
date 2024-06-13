# ATM Simulator

This project is an ATM (Automated Teller Machine) simulator built using Java Swing for the graphical user interface (GUI). The simulator provides a simple and interactive way to simulate basic ATM functionalities.

## Features

- **User Authentication**: Secure login using a PIN.
- **Balance Inquiry**: Check account balance.
- **Deposit**: Deposit money into your account.
- **Withdrawal**: Withdraw money from your account.
- **Transaction History**: View recent transactions.
- **Date Selection**: Integrated date picker for selecting dates.
- **Database Connectivity**: JDBC used for connecting to a relational database.

## Technologies Used

- Java
- Java Swing (for GUI)
- Java Collections Framework (for handling data)
- [JDatePicker](https://toedter.com/jdatepicker/) (for date selection)
- JDBC (for database connectivity)

## Prerequisites

- Java Development Kit (JDK) installed on your machine. You can download it [here](https://www.oracle.com/java/technologies/javase-downloads.html).
- JDBC driver for your specific database (e.g., MySQL Connector/J for MySQL).

## JAR Files Used

- **JDatePicker**: Used for date selection in the application. Ensure the `jdatepicker.jar` is included in your classpath.
- **JDBC Driver**: Used for connecting to a relational database. Ensure the relevant JDBC driver JAR (e.g., `mysql-connector-java.jar` for MySQL) is included in your classpath.

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Installation

1. **Clone the repository**
    ```bash
    git clone https://github.com/your-username/ATM-simulator.git
    cd ATM-simulator
    ```

2. **Add JAR files to the classpath**
    Ensure the following JAR files are included in your classpath:
    - `jdatepicker.jar`
    - `mysql-connector-java.jar` (or any other JDBC driver JAR relevant to your database)

3. **Compile the project**
    ```bash
    javac -cp ".:path/to/jdatepicker.jar:path/to/mysql-connector-java.jar" src/com/yourpackage/*.java
    ```

4. **Run the project**
    ```bash
    java -cp ".:path/to/jdatepicker.jar:path/to/mysql-connector-java.jar" src/com/yourpackage/ATMSimulator
    ```

## Usage

1. Launch the application.
2. Enter your user PIN to log in.
3. Use the GUI buttons to perform various transactions like balance inquiry, deposit, withdrawal, and view transaction history.
4. Use the date picker where applicable.
5. Log out when you are done.


