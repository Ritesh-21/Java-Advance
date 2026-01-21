import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      // Transaction handling In JDBC

        String url = "jdbc:mysql://localhost:3306/my_db";
        String username = "root";
        String password = "Ritesh2131";
        String withdrawquery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
        String depositequery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("✅ JDBC Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found: " + e.getMessage());
        }


        try {

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established ");

            con.setAutoCommit(false);
            try {
                PreparedStatement withdrawStatement = con.prepareStatement(withdrawquery);
                PreparedStatement depositStatement = con.prepareStatement(depositequery);
                withdrawStatement.setDouble(1, 500.00);
                withdrawStatement.setString(2, "account123");
                depositStatement.setDouble(1, 500.00);
                depositStatement.setString(2, "account456");
              int withdrawaffect =  withdrawStatement.executeUpdate();
                int depositaffect =  depositStatement.executeUpdate();

                if (withdrawaffect >0 && depositaffect >0){
                System.out.println("Transaction successful");

                }else {
                con.rollback();
                System.out.println("Transaction failed");

                }
                con.commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        catch (SQLException e) {
            System.out.println("jhol jhaal "+e.getMessage());
        }


    }
}