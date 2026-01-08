import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectDb {

        public static void main(String[] args) {

            // Database credentials
            String url = "jdbc:mysql://localhost:3306/Moto"; // "My_Db" ko apne database ke naam se replace karo
            String username = "root";                          // MySQL username
            String password = "Ritesh2131";                    // MySQL password

            try {
                // Optional: Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish the connection
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("✅ Connected to the database successfully!");

                // Close connection
                conn.close();
            } catch (ClassNotFoundException e) {
                System.out.println("❌ MySQL JDBC Driver not found. Add jar file to classpath.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("❌ Failed to connect to the database!");
                e.printStackTrace();
            }
        }
    }



