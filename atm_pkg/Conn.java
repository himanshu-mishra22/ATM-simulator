package atm_pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Conn {
    Connection c;
    Statement s;

    public Conn(){
        // Connection establishment
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");  // Ensure you have the MySQL connector JAR in your classpath

            // Connection creation
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms", "root", "Himanshu123@");
            System.out.println("Connection established: " + c);

            // Create statement
            s = c.createStatement();
            System.out.println("Statement created: " + s);

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to close resources
    public void close() {
        try {
            if (s != null) s.close();
            if (c != null) c.close();
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
