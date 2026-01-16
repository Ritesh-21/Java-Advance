import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Deleting data from database

        String url = "jdbc:mysql://localhost:3306/my_db";
        String username = "root";
        String password = "Ritesh2131";

        String query = "DELETE FROM student WHERE id = 3 AND name = 'Suhani'; ";

        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("✅ JDBC Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found: " + e.getMessage());
        }

        try{

            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection established ");
            Statement smt = con.createStatement();
            int rowsaffected = smt.executeUpdate(query);

            if (rowsaffected>0){
                System.out.println("Deletion Successful");
            }
            else{
                System.out.println("kuch to gadbaf hai deva ");
            }

            con.close();
            smt.close();

            System.out.println("Run effeciently");
        }
        catch (SQLException e) {
            System.out.println("jhol jhaal ");
        }




    }
    }
